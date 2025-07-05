package edu.byteprogramming.to_do.Repository;

import edu.byteprogramming.to_do.Model.Timer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TimerRepository extends JpaRepository<Timer, UUID> {
    
    // Buscar timers por usuario
    List<Timer> findByUserId(UUID userId);
    
    // Buscar timer activo por usuario
    Optional<Timer> findByUserIdAndIsRunningTrue(UUID userId);
    
    // Buscar timers por tarea
    List<Timer> findByTaskId(UUID taskId);
    
    // Buscar timers por usuario y tarea
    List<Timer> findByUserIdAndTaskId(UUID userId, UUID taskId);
    
    // Buscar timers por tipo de sesión (trabajo o descanso)
    List<Timer> findByUserIdAndIsWorkSession(UUID userId, boolean isWorkSession);
    
    // Contar timers completados (no activos) por usuario
    long countByUserIdAndIsRunningFalse(UUID userId);
}
