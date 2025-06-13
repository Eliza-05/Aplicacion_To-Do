package edu.byteprogramming.to_do.Controller;
import edu.byteprogramming.to_do.Model.Task;
import edu.byteprogramming.to_do.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(@RequestParam String query) {
        List<Task> results = taskService.searchTasks(query);
        return ResponseEntity.ok(results);
    }
}
