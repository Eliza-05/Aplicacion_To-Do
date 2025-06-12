package edu.byteprogramming.to_do.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.byteprogramming.to_do.Model.Statistics;
import java.util.UUID;

public interface StatisticsRepository extends JpaRepository<Statistics, UUID> {

}
