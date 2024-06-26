package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping
    public String viewCart(Model model) {
        // Add logic to retrieve cart items for the logged-in user
        // For simplicity, let's assume a list of items
        List<String> cartItems = Arrays.asList("Item 1", "Item 2", "Item 3");
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }
}
