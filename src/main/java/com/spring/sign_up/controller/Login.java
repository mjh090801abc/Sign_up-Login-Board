package com.spring.sign_up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class Login {

    @GetMapping("/login")
    public String login_Form() {
        return "login/login_form";
    }

    @PostMapping("/login")
    public String login_result(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {

        model.addAttribute("username", username);
        model.addAttribute("password", password);

            return "login/login_result";

    }
}
