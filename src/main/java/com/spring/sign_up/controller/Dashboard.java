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

    // 마이페이지 + 기능 {
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

        return "mainPage/in_mypage/edit_information";
    }

    // 정보 수정 (수정하기)
    @PostMapping("/edit_information")
    public String edit_information_change(@RequestParam String username,
                                          @RequestParam String email,
                                          @RequestParam String password,
                                          Model model) {

        model.addAttribute("username", username);
        model.addAttribute("email", email);

        if (password != null && !password.isEmpty()) {
            model.addAttribute("password", true);
        } else {
            model.addAttribute("password", false);
        }

        model.addAttribute("join_date", "2025-09-08");

        return "mainPage/mypage";

    }

    // 회원 탈퇴 (폼 보여주기)
    @GetMapping("/delete_member")
    public String delete_member_Form() {
        return "mainPage/in_mypage/delete_member_form";

    }

    // 회원 탈퇴 (탈퇴 처리)
    @PostMapping("/delete_member")
    public String delete_member_process(@RequestParam String username,
                                        @RequestParam String email,
                                        @RequestParam String password,
                                        Model model) {

        // DB 연결을 하지 않았으므로 임시로 값 입력
        String saved_username = "test_username";
        String saved_email = "test_email@example.com";
        String saved_password = "jh090801!!!";

        if (username.equals(saved_username) && email.equals(saved_email) && password.equals(saved_password)) {
            model.addAttribute("success_message", "회원 탈퇴가 성공적으로 처리되었습니다.");
            model.addAttribute("success", true);
        }

        return "delete_member_Form";
    }
    // }
}
