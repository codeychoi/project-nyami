package com.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.domain.User;

@Mapper
public interface UserMapper {
	int join(User user);
}
