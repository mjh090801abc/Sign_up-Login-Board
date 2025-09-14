package com.spring.sign_up.controller;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Board {

    private List<Post> posts = new ArrayList<>();
    private String loggedInUser = "mjh090801abc";
}
