package com.project.service;

import org.springframework.stereotype.Service;

import com.project.domain.Notice;
import com.project.mapper.NoticeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
	private final NoticeMapper noticeMapper;

	public void insertNotice(Notice notice) {
		noticeMapper.insertNotice(notice);
	}
}
