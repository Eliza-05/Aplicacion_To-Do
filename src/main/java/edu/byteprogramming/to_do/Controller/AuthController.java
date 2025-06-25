package edu.byteprogramming.to_do.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.byteprogramming.to_do.Repository.UserRepository;
import edu.byteprogramming.to_do.Model.User;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestParam String email) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            return "Email ya registrado";
        }

        return "Registro permitido";
    }
}