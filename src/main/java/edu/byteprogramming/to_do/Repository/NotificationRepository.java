package edu.byteprogramming.to_do.Repository;

import edu.byteprogramming.to_do.Model.Notification;
import edu.byteprogramming.to_do.Model.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {

    // Buscar notificaciones por usuario
    List<Notification> findByUserId(UUID userId);

    // Buscar notificaciones por usuario y tipo
    List<Notification> findByUserIdAndType(UUID userId, NotificationType type);

    // Buscar notificaciones no leídas por usuario
    List<Notification> findByUserIdAndReadFalse(UUID userId);

    // Contar notificaciones no leídas
    long countByUserIdAndReadFalse(UUID userId);

    // Buscar por tipo
    List<Notification> findByType(NotificationType type);

    // Eliminar todas las notificaciones de un usuario
    void deleteByUserId(UUID userId);
}