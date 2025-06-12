package edu.byteprogramming.to_do.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.byteprogramming.to_do.Model.SubTask;
import java.util.UUID;

public interface SubTaskRepository extends JpaRepository<SubTask, UUID> {

}
