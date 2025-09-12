package com.spring.sign_up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dashboard {
    // 메뉴 선택하는 대쉬보드
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

    // 정보 수정 (폼 보여주기)
    @GetMapping("/edit_information")
    public String edit_information_Form(Model model) {

        model.addAttribute("username", "test_username");
        model.addAttribute("email", "test_email@example.com");

        return "mainPage/edit_information";
    }

    @PostMapping("/edit_information")
    public String edit_information_change(@RequestParam String username,
                                          @RequestParam String email,
                                          @RequestParam String password,
                                          Model model) {

        model.addAttribute("username", username);
        model.addAttribute("email", email);


        return "mainPage/mypage";

    }
}
