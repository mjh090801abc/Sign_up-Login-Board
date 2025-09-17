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
public class Sign_up {

    @Autowired
    private UserService userService;

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

        // 새로운 user DB에 저장
        User newUser = new User(username, password, email);

        model.addAttribute("username", newUser.getUsername());
        model.addAttribute("password", newUser.getPassword());

        // 결과 페이지로 이동
        return "sign_up/signup_result";
    }
}
