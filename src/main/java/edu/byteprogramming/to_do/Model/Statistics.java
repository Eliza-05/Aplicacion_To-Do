package edu.byteprogramming.to_do.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "tasks_completed")
    private int tasksCompleted = 0;

    @Column(name = "tasks_created")
    private int tasksCreated = 0;

    @Column(name = "pomodoros_completed")
    private int pomodorosCompleted = 0;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructor vacío para JPA
    public Statistics() {
        this.createdAt = LocalDateTime.now();
        this.date = LocalDate.now();
    }

    // Constructor básico
    public Statistics(User user, LocalDate date) {
        this();
        this.user = user;
        this.date = date;
    }

    // Getters y setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getTasksCompleted() { return tasksCompleted; }
    public void setTasksCompleted(int tasksCompleted) { this.tasksCompleted = tasksCompleted; }

    public int getTasksCreated() { return tasksCreated; }
    public void setTasksCreated(int tasksCreated) { this.tasksCreated = tasksCreated; }

    public int getPomodorosCompleted() { return pomodorosCompleted; }
    public void setPomodorosCompleted(int pomodorosCompleted) { this.pomodorosCompleted = pomodorosCompleted; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    // Métodos útiles
    public void incrementTasksCompleted() {
        this.tasksCompleted++;
    }

    public void incrementTasksCreated() {
        this.tasksCreated++;
    }

    public void incrementPomodorosCompleted() {
        this.pomodorosCompleted++;
    }
}