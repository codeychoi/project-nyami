package com.project.dao;

import org.apache.ibatis.annotations.Mapper;

import com.project.model.LoginBean;

@Mapper
public interface LoginDao {

	LoginBean getUser(String userid);


	
}
