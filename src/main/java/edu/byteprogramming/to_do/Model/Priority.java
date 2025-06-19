package edu.byteprogramming.to_do.Model;

public enum Priority {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int level;

    Priority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public boolean isHigherThan(Priority priority) {
        return this.level > priority.level;
    }
}
