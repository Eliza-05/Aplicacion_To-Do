package edu.byteprogramming.to_do.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "timers")
public class Timer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "work_minutes", nullable = false)
    private int workMinutes = 25;

    @Column(name = "break_minutes", nullable = false)
    private int breakMinutes = 5;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "is_running")
    private boolean isRunning = false;

    @Column(name = "is_work_session")
    private boolean isWorkSession = true;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    // Constructor vacío requerido por JPA
    public Timer() {}

    // Constructor útil
    public Timer(int workMinutes, int breakMinutes, User user) {
        this.workMinutes = workMinutes;
        this.breakMinutes = breakMinutes;
        this.user = user;
    }

    // --- Getters y setters ---

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public int getWorkMinutes() { return workMinutes; }
    public void setWorkMinutes(int workMinutes) { this.workMinutes = workMinutes; }

    public int getBreakMinutes() { return breakMinutes; }
    public void setBreakMinutes(int breakMinutes) { this.breakMinutes = breakMinutes; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public boolean isRunning() { return isRunning; }
    public void setRunning(boolean running) { this.isRunning = running; }

    public boolean isWorkSession() { return isWorkSession; }
    public void setWorkSession(boolean workSession) { this.isWorkSession = workSession; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }

    // --- Métodos útiles ---

    /**
     * Inicia una sesión de trabajo o descanso según `isWorkSession`.
     */
    public void start() {
        this.startTime = LocalDateTime.now();
        this.endTime = startTime.plusMinutes(isWorkSession ? workMinutes : breakMinutes);
        this.isRunning = true;
    }

    /**
     * Finaliza el temporizador.
     */
    public void stop() {
        this.isRunning = false;
        this.endTime = null;
    }

    /**
     * Verifica si el temporizador ha expirado.
     */
    public boolean isExpired() {
        return isRunning && endTime != null && LocalDateTime.now().isAfter(endTime);
    }

    /**
     * Cambia entre sesión de trabajo y descanso, y reinicia.
     */
    public void switchSession() {
        this.isWorkSession = !this.isWorkSession;
        start();
    }
}

