package edu.byteprogramming.to_do.Repository;

import edu.byteprogramming.to_do.Model.Task;
import edu.byteprogramming.to_do.Model.TaskStatus;
import edu.byteprogramming.to_do.Model.Priority;
import edu.byteprogramming.to_do.Model.User;
import edu.byteprogramming.to_do.Model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    // Buscar todas las tareas de un usuario
    List<Task> findByUser(User user);

    // Buscar tareas por status
    List<Task> findByStatus(TaskStatus status);

    // Buscar tareas por prioridad
    List<Task> findByPriority(Priority priority);

    // Buscar tareas por usuario y status
    List<Task> findByUserAndStatus(User user, TaskStatus status);

    // Buscar tareas por usuario y prioridad
    List<Task> findByUserAndPriority(User user, Priority priority);

    // Buscar tareas por fecha límite
    List<Task> findByDueDate(LocalDate dueDate);

    // Buscar tareas por texto (título o descripción)
    List<Task> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);

    // Buscar tareas vencidas (fecha pasada y no completadas)
    @Query("SELECT t FROM Task t WHERE t.dueDate < :today AND t.status <> :completedStatus")
    List<Task> findOverdueTasks(@Param("today") LocalDate today, @Param("completedStatus") TaskStatus completedStatus);

    // Buscar tareas por rango de fechas
    List<Task> findByDueDateBetween(LocalDate startDate, LocalDate endDate);

    // Buscar tareas de un usuario por rango de fechas
    List<Task> findByUserAndDueDateBetween(User user, LocalDate startDate, LocalDate endDate);

    // Contar tareas por usuario
    long countByUser(User user);

    // Contar tareas completadas por usuario
    long countByUserAndStatus(User user, TaskStatus status);

    // Buscar tareas por lista de tareas (ToDoList)
    List<Task> findByTodoList(ToDoList todoList);

    // Buscar tareas por usuario y lista
    List<Task> findByUserAndTodoList(User user, ToDoList todoList);

    // Buscar tareas próximas a vencer (para notificaciones)
    @Query("SELECT t FROM Task t WHERE t.dueDate = :date AND t.status <> :completedStatus")
    List<Task> findTasksDueOn(@Param("date") LocalDate date, @Param("completedStatus") TaskStatus completedStatus);
}
