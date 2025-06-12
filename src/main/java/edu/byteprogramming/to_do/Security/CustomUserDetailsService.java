package edu.byteprogramming.to_do.Security;

import edu.byteprogramming.to_do.Model.User;
import edu.byteprogramming.to_do.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Cargar el usuario desde la base de datos y mapearlo a UserDetails
        return null;
    }
}
