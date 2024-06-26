package org.example.controller;

import org.example.model.Books;
import org.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String viewCart(Model model, Principal principal) {
        String username = principal.getName();
        List<Books> cartItems = cartService.getCartItemsForUser(username);
        model.addAttribute("cartItems", cartItems);

        if (cartItems.isEmpty()) {
            model.addAttribute("cartEmpty", true);
            model.addAttribute("message", "Your cart is empty");
        } else {
            model.addAttribute("cartEmpty", false);
            double totalPrice = cartItems.stream().mapToDouble(Books::getPrice).sum();
            model.addAttribute("totalPrice", totalPrice);
        }

        return "cart"; // Ensure this matches your Thymeleaf template name
    }

    @PostMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable Long id, Principal principal) {
        String username = principal.getName();
        cartService.removeFromCart(username, id);
        return "redirect:/cart";
    }
}
