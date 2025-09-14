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

    // List<Post> → 여러 개의 Post 객체 (Post 클래스에 맞는 리스트)를 모아두는 "박스" (자료구조)
    // new ArrayList<>() → 실제로 빈 박스를 하나 만든 것
    private List<Post> posts = new ArrayList<>();

    // 임시 로그인 유저 (DB 없이 테스트용)
    private String login_User = "mjh090801abc";

    // 메인 게시판
    @GetMapping("/board")
    public String main_board(Model model) {
        model.addAttribute("posts", posts);
        model.addAttribute("username", login_User);
        return "mainPage/in_mypage/board/board";
    }

    // 글쓰기 폼
    @GetMapping("/board/new")
    public String newPost_Form() {
        return "mainPage/in_mypage/board/newPost"; // → templates/board/newPost.html
    }

    // 글 등록
    @PostMapping("/board/add")
    public String add_Post(@RequestParam String content) {
        posts.add(new Post(login_User, content));
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
        // 변수만 선언
        private String username;
        private String content;

        // 변수 안에 값을 넣는 역할
        public Post(String username, String content) {
            this.username = username;
            this.content = content;
        }

        // "@Getter" 이거랑 같은 역할 (입력받은 변수의 값을 꺼낼 수 있는 코드)
        public String getUsername() { return username; }
        public String getContent() { return content; }
    }
}

