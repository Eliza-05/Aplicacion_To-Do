package edu.byteprogramming.to_do.Service;
import edu.byteprogramming.to_do.Model.Task;
import edu.byteprogramming.to_do.Repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasksByUser(UUID userId) {
        return taskRepository.findByUserId(userId);
    }

    public List<Task> searchTasks(String text) {
        return taskRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(text, text);
    }


    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public Optional<Task> getTaskById(UUID taskId) {
        return taskRepository.findById(taskId);
    }

    public void deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
    }
}
