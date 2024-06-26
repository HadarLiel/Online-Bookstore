package org.example.controller;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Assuming "register.html" or "register.jsp" is your registration form template
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user,
                               BindingResult result,
                               Model model) {
        // Custom validation for email and username uniqueness
        if (!result.hasErrors()) {
            // Check if email already exists
            User existingEmailUser = userRepository.findByEmail(user.getEmail());
            if (existingEmailUser != null) {
                result.rejectValue("email", null, "Email already exists.");
            }

            // Check if username already exists
            User existingUsernameUser = userRepository.findByUsername(user.getUsername());
            if (existingUsernameUser != null) {
                result.rejectValue("username", null, "Username already exists.");
            }
        }

        if (result.hasErrors()) {
            return "register"; // Return registration form again with validation errors
        }

        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/login"; // Redirect to login page after successful registration
    }
}
