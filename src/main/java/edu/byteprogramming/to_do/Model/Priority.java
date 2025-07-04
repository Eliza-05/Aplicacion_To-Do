package edu.byteprogramming.to_do.Model;

public enum Priority {
    LOW("Baja", "#2ECC40"),
    MEDIUM("Media", "#FFDC00"),
    HIGH("Alta", "#FF4136");
    
    private final String displayName;
    private final String color;
    
    Priority(String displayName, String color) {
        this.displayName = displayName;
        this.color = color;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public String getColor() {
        return color;
    }

    public static Priority fromDisplayName(String displayName) {
        for (Priority priority : values()) {
            if (priority.getDisplayName().equalsIgnoreCase(displayName)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("No se encontró la prioridad: " + displayName);
    }

}
