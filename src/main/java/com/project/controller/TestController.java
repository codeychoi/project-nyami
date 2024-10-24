package com.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@GetMapping
	public String test() {
		return "index";
	}
	
	@GetMapping("/rest")
	@ResponseBody
	public Map<String, Object> restTest() {
		Map<String, Object> test = new HashMap<> ();
		test.put("key1", 1);
		test.put("key2", 2345);
		test.put("key3", 'A');
		
		return test;
	}
}
