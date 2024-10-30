package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.domain.User;
import com.project.service.UserService;

public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
    public String login() {
        return "user/login";  // 로그인 페이지 반환
    }
	@GetMapping("/join")
	public String joinForm() {
		return "user/join";
	}
	@PostMapping("/join")
	public String join(User user) {
		userService.join(user);
		return "redirect:/";
	}
}
