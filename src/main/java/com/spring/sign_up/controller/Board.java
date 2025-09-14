package com.spring.sign_up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Board {

    private List<Post> posts = new ArrayList<>();
    private String loggedInUser = "mjh090801abc";

    // 메인 게시판
    @GetMapping("/board")
    public String main_board(Model model) {
        model.addAttribute("posts", posts);
        model.addAttribute("username", loggedInUser);
        return "mainPage/in_mypage/board/board";

    }

    // 글쓰기 폼
    @GetMapping("/board/new")
    public String newPost_Form(Model model) {
        return "mainPage/in_mypage/board/newPost";
    }

    // 글 등록을 처리
    @PostMapping("/board/add")
    public String add_Post(@RequestParam String content) {
        posts.add(new Post(loggedInUser, content));
        return "redirect:/board";

    }

    // 글 삭제
    @PostMapping("/board/delete")
    public String delete_Post(@RequestParam int index) {
        if (index >= 0 && index < posts.size()) {
            posts.remove(index);
        }
        return "redirect:/board";

    }

    // Post 클래스
    static class Post {
        private String username;
        private String content;

        public Post(String username, String content) {
            this.username = username;
            this.content = content;
        }
        public String getUsername() { return username; }
        public String getContent() { return content; }
    }

}


