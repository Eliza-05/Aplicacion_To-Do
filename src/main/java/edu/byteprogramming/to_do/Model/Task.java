package edu.byteprogramming.to_do.Model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;
    private Priority priority;
    //private Category category;
    private LocalDate crationDate;
    private Timer timer;
    private List<SubTask> subTasks;
    private List<Label> labels;

    public Task(String id, String title, String description, LocalDate dueDate, boolean completed, Priority priority, Category category, LocalDate creationDate, Timer timer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
        this.priority = priority;
        //this.category = category;
        this.crationDate = creationDate;
        this.timer = timer;
        this.subTasks = new ArrayList<>();
        //this.labels = new ArrayList<>();
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



}
