package edu.byteprogramming.to_do.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sub_tasks")
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;
    
    private String description;
    
    @Column(nullable = false)
    private boolean completed = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "parent_task_id")
    private Task parentTask;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    // Constructor vacío para JPA
    public SubTask() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Constructor básico
    public SubTask(String title, String description, Task parentTask) {
        this();
        this.title = title;
        this.description = description;
        this.parentTask = parentTask;
    }

    // Getters y setters
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

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { 
        this.completed = completed; 
        if (completed) {
            this.completedAt = LocalDateTime.now();
        } else {
            this.completedAt = null;
        }
        this.updatedAt = LocalDateTime.now();
    }

    public Task getParentTask() { return parentTask; }
    public void setParentTask(Task parentTask) { this.parentTask = parentTask; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public LocalDateTime getCompletedAt() { return completedAt; }


    public void toggleCompleted() {
        setCompleted(!this.completed);
    }
} 

