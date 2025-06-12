package edu.byteprogramming.to_do.Security;

import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetails;

@Component
public class JwtUtil {

    public String generateToken(UserDetails userDetails) {
        // Lógica para generar token
        return "";
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        // Lógica para validar el token
        return true;
    }

    public String extractUsername(String token) {
        // Lógica para extraer el username del token
        return "";
    }

}
