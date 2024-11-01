package com.example.mozispring.controller;

import com.example.mozispring.model.Eloadas;
import com.example.mozispring.model.Film;
import com.example.mozispring.model.Szinhaz;
import com.example.mozispring.model.User;
import com.example.mozispring.repository.EloadasRepository;
import com.example.mozispring.repository.FilmRepository;
import com.example.mozispring.repository.SzinhazRepository;
import com.example.mozispring.repository.UserRepository;
import com.example.mozispring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EloadasRepository eloadasRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private SzinhazRepository szinhazRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        boolean loggedIn = userDetails != null;
        model.addAttribute("loggedIn", loggedIn);
        model.addAttribute("username", loggedIn ? userDetails.getUsername() : null);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/data")
    public String showData(Model model) {
        List<Eloadas> eloadas = eloadasRepository.findAll();
        List<Film> filmek = filmRepository.findAll();
        List<Szinhaz> szinhazak = szinhazRepository.findAll();

        model.addAttribute("eloadas", eloadas);
        model.addAttribute("filmek", filmek);
        model.addAttribute("szinhazak", szinhazak);

        return "data";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {
        if (userRepository.findByFelhasznalonev(username) != null) {
            model.addAttribute("error", "A felhasználónév már foglalt.");
            return "register";
        }

        User user = new User();
        user.setFelhasznalonev(username);
        user.setJelszo(passwordEncoder.encode(password));
        userRepository.save(user);

        return "redirect:/login";
    }

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.validateUser(username, password);
        if (user != null) {
            return "redirect:/data";
        } else {
            model.addAttribute("error", "Hibás felhasználónév vagy jelszó.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
