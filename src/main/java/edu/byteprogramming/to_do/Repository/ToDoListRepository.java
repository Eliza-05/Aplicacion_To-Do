package edu.byteprogramming.to_do.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.byteprogramming.to_do.Model.ToDoList;
import java.util.UUID;

public interface ToDoListRepository extends JpaRepository<ToDoList, UUID> {

}