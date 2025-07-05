package edu.byteprogramming.to_do.Repository;

import edu.byteprogramming.to_do.Model.SubTask;
import edu.byteprogramming.to_do.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SubTaskRepository extends JpaRepository<SubTask, UUID> {

    // Obtener todas las subtareas de una tarea específica
    List<SubTask> findByParentTask(Task task);

    // Obtener subtareas completadas de una tarea
    List<SubTask> findByParentTaskAndCompletedTrue(Task task);

    // Obtener subtareas no completadas de una tarea
    List<SubTask> findByParentTaskAndCompletedFalse(Task task);

    // Contar cuántas subtareas tiene una tarea
    long countByParentTask(Task task);

    // Contar cuántas subtareas completadas tiene una tarea
    long countByParentTaskAndCompletedTrue(Task task);
}
