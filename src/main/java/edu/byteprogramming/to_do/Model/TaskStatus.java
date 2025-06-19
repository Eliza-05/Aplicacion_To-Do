package edu.byteprogramming.to_do.Model;

import java.time.LocalDate;

public enum TaskStatus {
    PENDING("Pendiente", "#3498db"),
    IN_PROGRESS("En Progreso", "#f39c12"),
    COMPLETED("Completada", "#2ecc71"),
    OVERDUE("Vencida", "#e74c3c");
    
    private final String displayName;
    private final String color;
    
    TaskStatus(String displayName, String color) {
        this.displayName = displayName;
        this.color = color;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public String getColor() {
        return color;
    }
    
    // Método para frontend
    public boolean isActive() {
        return this == PENDING || this == IN_PROGRESS;
    }
}
