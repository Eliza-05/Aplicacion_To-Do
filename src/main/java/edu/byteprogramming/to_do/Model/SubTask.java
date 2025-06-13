package edu.byteprogramming.to_do.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class SubTask {
    private UUID id;
    private String title;
    private boolean completed;
    private LocalDateTime creationDate;
    private LocalDate dueDate;
    private UUID taskId;

    public SubTask(String title, LocalDate dueDate, UUID taskId) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.completed = false;
        this.creationDate = LocalDateTime.now();
        this.dueDate = dueDate;
        this.taskId = taskId;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        this.completed = true;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }
}

