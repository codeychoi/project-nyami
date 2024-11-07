package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.domain.Member;
import com.project.domain.NoticeDomain;
import com.project.domain.Review;
import com.project.domain.Store;
import com.project.domain.Menu;
import com.project.mapper.MemberMapper;
import com.project.mapper.MenuMapper;
import com.project.mapper.NoticeMapper;
import com.project.mapper.ReviewMapper;
import com.project.mapper.StoreMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {
	private final NoticeMapper noticeMapper;
	private final MemberMapper memberMapper;
	private final StoreMapper storeMapper;
	private final MenuMapper menuMapper;
	private final ReviewMapper reviewMapper;  

	// 공지 작성
	public void insertNotice(NoticeDomain notice) {
		noticeMapper.insertNotice(notice);
	}
	
	// 유저 조회
	public List<Member> selectMembers(int page, int limit) {
		int start = (page - 1) * limit + 1;
		int end = start + limit - 1;
		
		return memberMapper.selectMembers(start, end);
	}
	
	// 특정 유저 조회
	public Member selectMember(long id) {
		return memberMapper.selectMember(id);
	}

	/*
	 * // 가게 목록 조회 public List<Store> selectStores(int page, int limit) { int start
	 * = (page - 1) * limit + 1; int end = start + limit - 1;
	 * 
	 * return storeMapper.selectStores(start, end); }
	 * 
	 * // 메뉴 조희 public List<Menu> selectMenus(long storeId) { return
	 * menuMapper.selectMenus(storeId); }
	 * 
	 * // 리뷰 조회 public List<Review> selectReviews(int page, int limit) { int start =
	 * (page - 1) * limit + 1; int end = start + limit - 1;
	 * 
	 * return reviewMapper.selectReviews(start, end); }
	 */
}
