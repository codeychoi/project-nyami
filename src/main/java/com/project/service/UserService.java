package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.domain.User;
import com.project.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	/*
	 * @Autowired private PasswordEncoder passwordEncoder; // BCrypt 해시 알고리즘 (암호화)
	 * 
	 * public int join(User user) { if
	 * (!user.getEmail().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) { throw new
	 * IllegalArgumentException("이메일 형식이 아닙니다."); } if (user.getPassword().length()
	 * < 8) { throw new IllegalArgumentException("비밀번호는 8자리 이상입니다."); }
	 * user.setPassword(passwordEncoder.encode(user.getPassword())); return
	 * userMapper.join(user); }
	 */
}
