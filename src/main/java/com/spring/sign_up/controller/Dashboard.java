package com.spring.sign_up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dashboard {

    @GetMapping("/dashboard")
    public String dashboard_Form() {
        return "mainPage/dashboard";
    }

    @GetMapping("/myPage")
    public String myPage_Form(Model model) {

        model.addAttribute("username", "test_username");
        model.addAttribute("email", "test_email");
        model.addAttribute("join_date", "test_join_date");

        return "mainPage/myPage";
    }
}
