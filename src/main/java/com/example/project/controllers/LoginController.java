package com.example.project.controllers;

import com.example.project.entity.User;
import com.example.project.rep.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/login")
    public Map<String, Object> login(String username, String password) {
        User user = userRepository.findByUsername(username);
        boolean validLogin = (user != null) && (user.getPassword().equals(password));

        Map<String, Object> map = new HashMap<>();
        map.put("validLogin", validLogin);
        return map;

    }
}
