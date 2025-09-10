package com.spring.sign_up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sign_up {

    // 회원가입 폼 열기
    @GetMapping("/sign_up")
    public String SignUp_form() {
        return "signup_form";
    }

    // 회원가입 처리
    @PostMapping("/sign_up")
    public String SignUp_result(@RequestParam String username,
                                @RequestParam String password,
                                @RequestParam String email,
                                Model model) {

        // 입력값을 모델에 담기
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);

        // 결과 페이지로 이동
        return "signup_result";
    }
}
