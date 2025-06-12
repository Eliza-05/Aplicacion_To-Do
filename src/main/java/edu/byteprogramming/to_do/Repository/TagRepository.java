package edu.byteprogramming.to_do.Repository;
import edu.byteprogramming.to_do.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {

}
