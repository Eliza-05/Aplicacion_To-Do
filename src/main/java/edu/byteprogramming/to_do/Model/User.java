package edu.byteprogramming.to_do.Model;

import java.util.ArrayList;

public class User {
    private Integer id = 0;
    private static Integer idCounter = 0;
    private String username;
    private String email;
    private String password;
    private ArrayList<Task> tasks = new ArrayList<>();

    public User(String username, String email, String password) {
        this.id = idCounter++;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void createTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

}
