package com.leeonscoding.formauthentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @GetMapping(value = {"/login", "/logout"})
    public String loginPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login.html";
    }

    @GetMapping("/secure/home")
    public String home(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        return "home.html";
    }

    @GetMapping("/admin/dashboard")
    public String data(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        return "data.html";
    }
}
