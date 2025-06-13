package edu.byteprogramming.to_do.Model;

import java.time.LocalDateTime;

public class Notification {
    private String id;
    private NotificationType type;
    private String message;
    private LocalDateTime triggerTime;
    private boolean delivered;

    public Notification(String id, NotificationType type, String message, LocalDateTime triggerTime) {
        this.id = id;
        this.type = type;
        this.message = message;
        this.triggerTime = triggerTime;
        this.delivered = false;
    }

    public void deliver() {
        this.delivered = true;
    }

    public boolean isDue() {
        return LocalDateTime.now().isAfter(triggerTime) && !delivered;
    }

}