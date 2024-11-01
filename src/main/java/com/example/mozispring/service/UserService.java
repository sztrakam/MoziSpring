package com.example.mozispring.service;

import com.example.mozispring.model.User;
import com.example.mozispring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User validateUser(String felhasznalonev, String jelszo) {
        User user = userRepository.findByFelhasznalonev(felhasznalonev);
        if (user != null) {
            System.out.println("Felhasználó megtalálva: " + user.getFelhasznalonev());
            System.out.println("Beírt jelszó: " + jelszo);
            System.out.println("Tárolt jelszó: " + user.getJelszo());
            if (passwordEncoder.matches(jelszo, user.getJelszo())) {
                return user;
            } else {
                System.out.println("Jelszó nem egyezik.");
            }
        } else {
            System.out.println("Felhasználó nem található.");
        }
        return null;
    }
}
