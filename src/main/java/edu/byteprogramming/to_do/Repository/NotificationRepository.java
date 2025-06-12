package edu.byteprogramming.to_do.Repository;
import edu.byteprogramming.to_do.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {

}
