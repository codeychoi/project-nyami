package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class boardController {

	@GetMapping("/noticeList")
	public String noticeList() {
		return "board/noticeList";
	}
}
