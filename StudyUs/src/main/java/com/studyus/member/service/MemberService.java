package com.studyus.member.service;

import java.util.ArrayList;
 
import com.studyus.enrollment.domain.Enrollment;
import com.studyus.member.domain.Member;
import com.studyus.review.domain.Review;

public interface MemberService { 

	public Member loginMember(Member member);
	
	public int registerMember(Member member);
	
	public int modifyMember(Member member);
	
	public int removeMember(String mbId);
	
	public int checkIdDup(String mbId);
	
	public int checkNickDup(String mbNickname);
	
	public Member findMemId(Member member);
	
	public Member findMemPw(Member member);
	
	public ArrayList<Enrollment> myStudyList(int mbNo);
	
	public Review myReviewList(String mbId);
	
	/**
	 * 해당 번호의 스터디에 가입한 모든 회원을 출력합니다.
	 * @param studyNo
	 * @return ArrayList<Member>
	 */
	public ArrayList<Member> printAllByStudyNo(int studyNo);
}
