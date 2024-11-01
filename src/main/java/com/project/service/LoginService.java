package com.project.service;

import org.springframework.stereotype.Service;

import com.project.dao.LoginDao;
import com.project.model.LoginBean;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final LoginDao loginDao;

	    
	public LoginBean getUser(String userid) {
		return loginDao.getUser(userid);
	}

	

	
	
}
