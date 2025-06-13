package edu.byteprogramming.to_do.Model;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ToDoList {

    private UUID id;
    private String name;
    private String description;
    private List<Task> tasks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private User owner;

    public ToDoList(UUID id, String name, String description, User owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tasks = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.owner = owner;
    }

     // Getters y setters
    public UUID getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
        this.updatedAt = LocalDateTime.now();
    }
    
    public String getDescription() {
        return description;
    }
    
    public List<Task> getTasks() {
        return tasks;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public User getOwner() {
        return owner;
    }


}
