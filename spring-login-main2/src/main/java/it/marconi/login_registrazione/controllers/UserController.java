package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/user")
    public String utente(@RequestParam("type") String type, Model model) {
        if ("new".equals(type)) {
            model.addAttribute("title", "Registrazione Utente");
        } else if ("login".equals(type)) {
            model.addAttribute("title", "Login Utente");
        } else {
            return "redirect:/";
        }
        model.addAttribute("type", type);
        return "index";
    }

    @PostMapping("/user/submit")
    public String submit(@RequestParam("username") String username, Model model) {
        model.addAttribute("username", username);
        return "redirect:/user/" + username;
    }

    @GetMapping("/user/{username}")
    public String recap(@RequestParam("username") String username, Model model) {
        model.addAttribute("username", username);
        return "recap";
    }
}
