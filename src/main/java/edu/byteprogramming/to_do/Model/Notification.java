package edu.byteprogramming.to_do.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    @Column(nullable = false)
    private String message;

    @Column(name = "trigger_time", nullable = false)
    private LocalDateTime triggerTime;

    @Column(name = "is_delivered")
    private boolean delivered = false;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    // Constructor vacío para JPA
    public Notification() {}

    // Constructor básico
    public Notification(NotificationType type, String message, LocalDateTime triggerTime, User user) {
        this.type = type;
        this.message = message;
        this.triggerTime = triggerTime;
        this.user = user;
    }

    // Getters y setters básicos
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public NotificationType getType() { return type; }
    public void setType(NotificationType type) { this.type = type; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getTriggerTime() { return triggerTime; }
    public void setTriggerTime(LocalDateTime triggerTime) { this.triggerTime = triggerTime; }

    public boolean isDelivered() { return delivered; }
    public void setDelivered(boolean delivered) { this.delivered = delivered; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }

    // Métodos útiles
    public void deliver() {
        this.delivered = true;
    }

    public boolean isDue() {
        return LocalDateTime.now().isAfter(triggerTime) && !delivered;
    }
}