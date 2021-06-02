package com.studyus.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.studyus.board.domain.Board;
import com.studyus.common.PageInfo; 
 
public interface BoardService {
	
	// 게시물 보기
	
	/**
	 * 전체 게시물 수(원글번호가 null인 것만 가져오기 / 카테고리별로)
	 * @param board(stNo, boCategory)
	 * @return
	 */
	public int getListCount(Board board);
	
	/**
	 * 전체보기(5개씩)
	 * @param pi
	 * @param board(stNo, boCategory)
	 * @return
	 */
	public ArrayList<Board> printAll(PageInfo pi, Board board);
	
	/**
	 * 게시물에 해당하는 댓글 최신순으로 하나만
	 * @param boMotherNo
	 * @return
	 */
	public Board printOneReply(int boMotherNo);
	
	/**
	 * 검색한 게시물 총 개수 - 전체 / 마이페이지 / 팀장페이지
	 * (마이페이지 검색은 멤버가 null이 아닐 때)
	 * @param map
	 * @return
	 */
	public int getSearchCount(HashMap<String, Object> map);
	
	/**
	 * 검색하기 - 전체 / 마이페이지 / 팀장페이지
	 * (마이페이지 검색은 멤버가 null이 아닐 때)
	 * @param pi
	 * @param board(stNo, boCategory)
	 * @return
	 */
	public ArrayList<Board> printSearchAll(PageInfo pi, HashMap<String, Object> map);
	
	/**
	 * 한개 보기 (WHERE BO_NO)
	 * @param boNo
	 * @return
	 */
	public Board printOne(int boNo);
	
	/**
	 * 한개 댓글 보기 (WHERE BO_MOTHER_NO)
	 * @param pi
	 * @param boMotherNo
	 * @return
	 */
	public ArrayList<Board> printAllReply(PageInfo pi, int boMotherNo);
	
	/////////////////////////////////////////////////////////////////////////////////
	
	// 게시물과 댓글 추가, 수정, 삭제
	public int registerBoard(Board board);
	public int modifyBoard(Board board);
	public int removeBoard(int boNo);
	
	///////////////////////////////////////////////////////////////////////////////// 관리
		
	/**
	 * 전체 게시물 보기(paging x)
	 * @param stNo
	 * @return
	 */
	public ArrayList<Board> printAllByStNo(int stNo);
	
	/**
	* 내가 쓴 게시물 전체 보기
	* @param board(mbNo, stNo)
	* @return
	*/
	public ArrayList<Board> printAllByMemberNo(Board board);
	
	// 댓글 
	
	/**
	* 전체 댓글 보기(paging x)
	* @param stNo
	* @return
	*/
	public ArrayList<Board> printAllReplyByStNo(int stNo);
	
	/**
	* 내가 쓴 댓글 전체 보기
	* @param board(mbNo, stNo)
	* @return
	*/
	public ArrayList<Board> printAllReplyByMemberNo(Board board);

}
