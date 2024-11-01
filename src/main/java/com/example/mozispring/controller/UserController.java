package com.example.mozispring.controller;

import com.example.mozispring.model.User;
import com.example.mozispring.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String felhasznalonev,
                               @RequestParam String jelszo,
                               Model model,
                               HttpSession session) { // Importáld a HttpSession-t
        User user = userService.validateUser(felhasznalonev, jelszo);
        if (user != null) {
            session.setAttribute("loggedIn", true); // Beállítjuk a session-ben
            return "redirect:/";
        } else {
            model.addAttribute("error", "Hibás felhasználónév vagy jelszó.");
            return "login";
        }
    }

}

