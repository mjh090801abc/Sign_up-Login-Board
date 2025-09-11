package com.spring.sign_up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Dashboard {
    // 마이페이지
    @GetMapping("/dashboard")
    public String dashboard_Form() {
        return "mainPage/dashboard";
    }

    // 마이페이지
    @GetMapping("/mypage")
    public String myPage_Form(Model model) {

        model.addAttribute("username", "test_username");
        model.addAttribute("email", "test_email@example.com");
        model.addAttribute("join_date", "2025-09-08");

        return "mainPage/mypage";
    }
}
