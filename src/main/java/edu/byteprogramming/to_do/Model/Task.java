package edu.byteprogramming.to_do.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    private String description;

    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    private ToDoList todoList;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "parentTask", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubTask> subTasks = new ArrayList<>();

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    // Constructor vacío requerido por JPA
    public Task() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Constructor básico
    public Task(String title, String description, LocalDate dueDate, Priority priority, User user) {
        this();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.user = user;
    }

    // --- Getters y setters ---

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) {
        this.title = title;
        this.updatedAt = LocalDateTime.now();
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        this.updatedAt = LocalDateTime.now();
    }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) {
        this.priority = priority;
        this.updatedAt = LocalDateTime.now();
    }

    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();

        if (status == TaskStatus.COMPLETED) {
            this.completedAt = LocalDateTime.now();
        } else {
            this.completedAt = null;
        }
    }

    public ToDoList getTodoList() { return todoList; }
    public void setTodoList(ToDoList todoList) { this.todoList = todoList; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<SubTask> getSubTasks() { return subTasks; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public LocalDateTime getCompletedAt() { return completedAt; }

    // --- Métodos útiles ---

    public boolean isCompleted() {
        return this.status == TaskStatus.COMPLETED;
    }

    public boolean isOverdue() {
        if (this.status == TaskStatus.COMPLETED || this.dueDate == null) return false;
        return LocalDate.now().isAfter(this.dueDate);
    }

    public void addSubTask(SubTask subTask) {
        this.subTasks.add(subTask);
        subTask.setParentTask(this);
        this.updatedAt = LocalDateTime.now();
    }

    public void removeSubTask(SubTask subTask) {
        this.subTasks.remove(subTask);
        subTask.setParentTask(null);
        this.updatedAt = LocalDateTime.now();
    }

    public int getCompletionPercentage() {
        if (subTasks.isEmpty()) {
            return this.status == TaskStatus.COMPLETED ? 100 : 0;
        }

        int completedCount = 0;
        for (SubTask subTask : subTasks) {
            if (subTask.isCompleted()) {
                completedCount++;
            }
        }
        return (completedCount * 100) / subTasks.size();
    }
}
