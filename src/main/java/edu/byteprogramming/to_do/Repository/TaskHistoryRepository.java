package edu.byteprogramming.to_do.Repository;
import edu.byteprogramming.to_do.Model.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory, UUID> {

}
