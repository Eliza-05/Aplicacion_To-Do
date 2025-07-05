package edu.byteprogramming.to_do.Repository;

import edu.byteprogramming.to_do.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    
    // Buscar usuario por email
    Optional<User> findByEmail(String email);
    
    // Buscar usuario por username
    Optional<User> findByUsername(String username);
    
    // Verificar si existe un email
    boolean existsByEmail(String email);
    
    // Verificar si existe un username
    boolean existsByUsername(String username);
    
    // Buscar por email o username
    Optional<User> findByEmailOrUsername(String email, String username);
}