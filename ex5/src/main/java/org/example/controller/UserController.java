package org.example.controller;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
                               Model model,
                               HttpServletRequest request) {
        if (result.hasErrors()) {
            return "register"; // Return registration form again if validation fails
        }

        // Check if username already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            model.addAttribute("registrationError", "Username already exists.");
            return "register"; // Return registration form with error message
        }

        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        // Optional: Add user to session after registration
        HttpSession session = request.getSession();
        session.setAttribute("loggedInUser", user);

        return "redirect:/login"; // Redirect to login page after successful registration
    }
}
