package com.studyus.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studyus.member.domain.Member;
import com.studyus.member.store.MemberStore;
import com.studyus.review.domain.Review;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	public MemberStore store;
	
	@Override
	public Member loginMember(Member member) {
		Member mOne = store.selectOneMember(member);
		return mOne;
	}

	@Override
	public int registerMember(Member member) {
		int result = store.insertMember(member);
		return result;
	}

	@Override
	public int modifyMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeMember(String mbId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkIdDup(String mbId) {
		return store.checkIdDup(mbId);
	}
	
	@Override
	public int checkNickDup(String mbNickname) {
		return store.checkNickDup(mbNickname);
	}

	@Override
	public Member findMemId(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member findMemPw(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review myReviewList(String mbId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
