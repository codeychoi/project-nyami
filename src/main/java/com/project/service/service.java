package com.project.service;

import org.springframework.stereotype.Service;

import com.project.dao.storeDetailDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class service {

	private final storeDetailDao dao;
	
}
