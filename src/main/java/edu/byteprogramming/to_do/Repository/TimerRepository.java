package edu.byteprogramming.to_do.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.byteprogramming.to_do.Model.Timer;
import java.util.UUID;

public interface TimerRepository extends JpaRepository<Timer, UUID> {

}
