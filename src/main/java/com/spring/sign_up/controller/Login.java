package com.spring.sign_up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {

    @GetMapping("/login")
    public String login_Form() {
        return "login_form";
    }

    @PostMapping("/login")
    public String login_result(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {

        model.addAttribute("username", username);
        model.addAttribute("password", password);

        return "login_result";
    }
}
