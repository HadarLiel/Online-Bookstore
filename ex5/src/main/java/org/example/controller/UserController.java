package org.example.controller;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for handling user-related operations
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Displays the registration form
     * @param model The model to add attributes to
     * @return The name of the registration view
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * Processes the user registration
     * @param user The user to register
     * @param result The binding result for validation errors
     * @param model The model to add attributes to
     * @return The name of the view to display
     */
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user,
                               BindingResult result,
                               Model model) {
        if (!result.hasErrors()) {
            User existingEmailUser = userRepository.findByEmail(user.getEmail());
            if (existingEmailUser != null) {
                result.rejectValue("email", null, "Email already exists.");
            }

            User existingUsernameUser = userRepository.findByUsername(user.getUsername());
            if (existingUsernameUser != null) {
                result.rejectValue("username", null, "Username already exists.");
            }
        }

        if (result.hasErrors()) {
            return "register";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/login";
    }
}