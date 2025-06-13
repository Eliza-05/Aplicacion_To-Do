package edu.byteprogramming.to_do.Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Timer {
    private Duration workDuration;
    private Duration breakDuration;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean isRunning;
    private boolean isWorkSession;

    public Timer(Duration workDuration, Duration breakDuration) {
        this.workDuration = workDuration;
        this.breakDuration = breakDuration;
        this.isRunning = false;
        this.isWorkSession = true;
    }

    public void start() {
        this.startTime = LocalDateTime.now();
        this.endTime = isWorkSession
                ? startTime.plus(workDuration)
                : startTime.plus(breakDuration);
        this.isRunning = true;
    }

    public void stop() {
        this.isRunning = false;
    }

    public boolean isExpired() {
        return isRunning && LocalDateTime.now().isAfter(endTime);
    }

    public long getRemainingMinutes() {
        return Duration.between(LocalDateTime.now(), endTime).toMinutes();
    }

    public void switchSession() {
        isWorkSession = !isWorkSession;
        start(); // reinicia el temporizador con la nueva sesión
    }

}

