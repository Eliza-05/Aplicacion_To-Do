package edu.byteprogramming.to_do.Model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task {
    private UUID id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
    private Priority priority;
    //private Category category;
    private LocalDate crationDate;
    private LocalDateTime createdAt;
    private Timer timer;
    private List<SubTask> subTasks;
    private UUID userId;
    //private List<Label> labels;

    public Task(UUID id, String title, String description, LocalDate dueDate, boolean completed, Priority priority, LocalDate creationDate, Timer timer, UUID userID) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
        this.priority = priority;
        //this.category = category;
        this.createdAt = LocalDateTime.now();
        this.timer = timer;
        this.subTasks = new ArrayList<>();
        this.userId = userID;
        //this.labels = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public void setCompleted() {
        this.completed = true;
    }

    public void addSubTask(SubTask subTask) {
        this.subTasks.add(subTask);
    }

    public void addLabel(String label) {
        //Label labelObj = new Label(label);
        //this.labels.add(labelObj);

    }

    public void addRecord() {
        // Lógica para agregar un registro de la tarea
    }


    public void addNotification() {
        // Lógica para agregar una notificación para la tarea
    }


    /**
     *
     * @param othertask
     * @return
     */
    public boolean hasHigherPriorityThan(Task othertask) {
        return this.priority.isHigherThan(othertask.priority);
    }


}
