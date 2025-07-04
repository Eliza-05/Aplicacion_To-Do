package edu.byteprogramming.to_do.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "to_do_lists")
public class ToDoList {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "todoList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    // Constructor vacío para JPA
    public ToDoList() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Constructor útil
    public ToDoList(String name, String description, User owner) {
        this();
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    // --- Getters y Setters ---

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }

    public String getDescription() { return description; }
    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }



    public void addTask(Task task) {
        this.tasks.add(task);
        task.setTodoList(this);
        this.updatedAt = LocalDateTime.now();
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
        task.setTodoList(null);
        this.updatedAt = LocalDateTime.now();
    }

    public List<Task> getCompletedTasks() {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }


    public List<Task> getPendingTasks() {
        List<Task> pendingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }

    public int getCompletionPercentage() {
        if (tasks.isEmpty()) return 0;
        int completed = getCompletedTasks().size();
        return (completed * 100) / tasks.size();
    }

    public List<Task> getTasksByPriority(Priority priority) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }


    public List<Task> getOverdueTasks() {
        List<Task> overdueTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isOverdue()) {
                overdueTasks.add(task);
            }
        }
        return overdueTasks;
    }


    public List<Task> searchTasksByTitle(String query) {
        List<Task> matchingTasks = new ArrayList<>();
        String lowercaseQuery = query.toLowerCase();
        
        for (Task task : tasks) {
            if (task.getTitle() != null && task.getTitle().toLowerCase().contains(lowercaseQuery)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }


    public double getAverageCompletionTimeInDays() {
        List<Task> completedTasks = getCompletedTasks();
        if (completedTasks.isEmpty()) {
            return 0;
        }

        long totalDays = 0;
        for (Task task : completedTasks) {
            if (task.getCreatedAt() != null && task.getCompletedAt() != null) {
                totalDays += java.time.Duration.between(task.getCreatedAt(), task.getCompletedAt()).toDays();
            }
        }

        return (double) totalDays / completedTasks.size();
    }

}
