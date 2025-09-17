package com.spring.sign_up.controller;

import com.spring.sign_up.entity.User;
import com.spring.sign_up.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Login {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login_Form() {
        return "login/login_form";
    }

    @PostMapping("/login")
    public String login_result(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {

        User user = userService.login(username, password);
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "login/login_result";

        } else {
            model.addAttribute("message", "아이디 또는 비번이 잘못되었습니다.");
            return "login/login_fail";
        }
    }
}
