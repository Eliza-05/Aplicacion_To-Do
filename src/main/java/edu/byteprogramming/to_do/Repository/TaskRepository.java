package edu.byteprogramming.to_do.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.byteprogramming.to_do.Model.Task;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByUserId(UUID userId);
    List<Task> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String titleText, String descriptionText);

}
