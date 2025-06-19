package edu.byteprogramming.to_do.Model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;
import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue
    private UUID id;
    private String title;
    private String description;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Priority priority;


    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    private ToDoList todoList;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(mappedBy = "parentTask", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubTask> subTasks = new ArrayList<>();
    
    //private Category category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime completedAt;
    //private List<Label> labels;



    // Constructor vacío requerido por JPA
    public Task() {
    }


    public Task(UUID id, String title, String description, LocalDate dueDate, boolean completed, Priority priority, LocalDate creationDate, Timer timer, UUID userID) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        //this.category = category;
        this.status = status;
        this.user = user;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        //this.labels = new ArrayList<>();
    }

// Getters y setters
    public UUID getId() { 
        return id; 
    }

    public void setId(UUID id) { 
        this.id = id; 
    }

    public String getTitle() { 
        return title; 
    }
    public void setTitle(String title) { 
        this.title = title; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) { 
        this.description = description; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public LocalDate getDueDate() { 
        return dueDate; 
    }
    public void setDueDate(LocalDate dueDate) { 
        this.dueDate = dueDate; 
        this.updatedAt = LocalDateTime.now();
    }
    
    public Priority getPriority() {
        return priority; 
    }
    public void setPriority(Priority priority) { 
        this.priority = priority; 
        this.updatedAt = LocalDateTime.now();
    }

    public TaskStatus getStatus() { 
        return status; 
    }

    public void setStatus(TaskStatus status) { 
    this.status = status;
    
    if (status == TaskStatus.COMPLETED) {
        this.completedAt = LocalDateTime.now();
    } 
    else if (this.completedAt != null) {
        this.completedAt = null;
    }
    this.updatedAt = LocalDateTime.now();
    }
    

    public ToDoList getTodoList() { 
        return todoList; 
    }
    public void setTodoList(ToDoList todoList) { 
        this.todoList = todoList; 
    }
    
    public Category getCategory() { 
        return category; 
    }
    public void setCategory(Category category) { 
        this.category = category; 
        this.updatedAt = LocalDateTime.now();
    }

    public User getUser() { 
        return user; 
    }
    public void setUser(User user) { 
        this.user = user; 
    }
    
    public List<SubTask> getSubTasks() { 
        return subTasks; 
    }
    
    public LocalDateTime getCreatedAt() { 
        return createdAt; 
    }
    
    public LocalDateTime getUpdatedAt() { 
        return updatedAt; 
    }
    
    public LocalDateTime getCompletedAt() { 
        return completedAt; 
    }



    public boolean isCompleted() {
    return this.status == TaskStatus.COMPLETED;
    }

    
    // Métodos para gestionar subtareas
    public void addSubTask(SubTask subTask) {
        subTasks.add(subTask);
        subTask.setParentTask(this);
        this.updatedAt = LocalDateTime.now();
    }
    
    public void removeSubTask(SubTask subTask) {
        subTasks.remove(subTask);
        subTask.setParentTask(null);
        this.updatedAt = LocalDateTime.now();
    }

    public boolean isOverdue() {
    if (this.status == TaskStatus.COMPLETED) return false;
    return LocalDate.now().isAfter(this.dueDate);
}

// Método para calcular el progreso basado en subtareas
public int getCompletionPercentage() {
    if (subTasks.isEmpty()) {
        return (this.status == TaskStatus.COMPLETED) ? 100 : 0;
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
