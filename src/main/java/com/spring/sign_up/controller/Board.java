package com.spring.sign_up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Board {

    private List<Post> posts = new ArrayList<>();
    private String loggedInUser = "mjh090801abc";

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("posts", posts);
        model.addAttribute("username", loggedInUser);
        return "mainPage/in_mypage/board/board";

    }
}


