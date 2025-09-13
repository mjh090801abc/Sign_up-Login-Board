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
        return "sign_up/signup_form";
    }

    // 회원가입 처리
    @PostMapping("/sign_up")
    public String SignUp_result(@RequestParam String username, // @RequestParam는 사용자가 입력한 값을 매개변수로 받아서 저장
                                @RequestParam String password,
                                @RequestParam String email,
                                Model model) {

        // 입력값을 모델에 담기
        model.addAttribute("username", username); // @RequestParam 으로 사용자에게 받은 데이터를 보여주는 역할
        model.addAttribute("password", password);
        model.addAttribute("email", email);

        // 결과 페이지로 이동
        return "sign_up/signup_result";
    }
}
