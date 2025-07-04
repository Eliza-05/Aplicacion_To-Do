package edu.byteprogramming.to_do.Model;

public enum TaskStatus {
    PENDING("Pendiente", "#3498db"),
    IN_PROGRESS("En Progreso", "#f39c12"),
    COMPLETED("Completada", "#2ecc71"),
    OVERDUE("Vencida", "#e74c3c");

    private final String displayName;
    private final String colorHex;

    TaskStatus(String displayName, String colorHex) {
        this.displayName = displayName;
        this.colorHex = colorHex;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getColorHex() {
        return colorHex;
    }

    /**
     * Indica si el estado es activo (aún no terminado ni vencido).
     */
    public boolean isActive() {
        return this == PENDING || this == IN_PROGRESS;
    }

    /**
     * Indica si la tarea ya no debería requerir acciones del usuario.
     */
    public boolean isTerminal() {
        return this == COMPLETED || this == OVERDUE;
    }
}

