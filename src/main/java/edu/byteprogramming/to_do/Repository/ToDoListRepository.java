package edu.byteprogramming.to_do.Repository;

import edu.byteprogramming.to_do.Model.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, UUID> {
    
    // Buscar listas por usuario (owner)
    List<ToDoList> findByOwnerId(UUID ownerId);
    
    // Buscar listas por nombre
    List<ToDoList> findByNameContainingIgnoreCase(String name);
    
    // Buscar listas por usuario y nombre
    List<ToDoList> findByOwnerIdAndNameContainingIgnoreCase(UUID ownerId, String name);
    
    // Buscar por palabra clave en nombre o descripción
    List<ToDoList> findByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String name, String description);
    
    // Contar listas por usuario
    long countByOwnerId(UUID ownerId);
}
