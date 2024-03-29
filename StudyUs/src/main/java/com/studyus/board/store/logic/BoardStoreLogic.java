package com.studyus.board.store.logic;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studyus.board.domain.Board;
import com.studyus.board.store.BoardStore;
import com.studyus.common.PageInfo;

@Repository
public class BoardStoreLogic implements BoardStore{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int getListCount(Board board) {
		return sqlSession.selectOne("boardMapper.selectListCount", board);
	}

	@Override
	public ArrayList<Board> selectAll(PageInfo pi, Board board) {
		int offset = (pi.getCurrentPage() - 1) *pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("boardMapper.selectAllList", board, rowBounds);
	}
	
	@Override
	public Board selectOneReply(int boMotherNo) {
		return sqlSession.selectOne("boardMapper.selectOneReply", boMotherNo);
	}

	@Override
	public int getSearchCount(HashMap<String, Object> map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}

	@Override
	public ArrayList<Board> selectSearchAll(PageInfo pi, HashMap<String, Object> map) {
		int offset = (pi.getCurrentPage() - 1) *pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}

	@Override
	public Board selectOne(int boNo) {
		return sqlSession.selectOne("boardMapper.selectOne", boNo);
	}

	@Override
	public ArrayList<Board> selectAllReply(PageInfo pi, int boMotherNo) {
		int offset = (pi.getCurrentPage() - 1) *pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("boardMapper.selectAllReply", boMotherNo, rowBounds);
	}

	@Override
	public int insertBoard(Board board) {
		sqlSession.insert("boardMapper.insertBoard", board);
		return board.getBoNo();
		// 리턴값은 등록된 boNo
		// 댓글도 마찬가지지만 굳이 사용할 필요 없음!
	}

	@Override 
	public int updateBoard(Board board) {
		return sqlSession.update("boardMapper.updateBoard", board);
	}

	@Override
	public int deleteBoard(int boNo) {
		int reResult = sqlSession.update("boardMapper.deleteReply", boNo);
		int boResult = sqlSession.update("boardMapper.deleteBoard", boNo);
		return reResult + boResult;
	}

	///////////////////////////////////////////////////////////////////////////////// 관리

	@Override
	public ArrayList<Board> selectAllByStNo(int stNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.selectAllListByStNo", stNo);
	}

	@Override
	public ArrayList<Board> selectAllByMemberNo(Board board, int selected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Board> selectAllReplyByStNo(int stNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Board> selectAllReplyByMemberNo(Board board) {
		// TODO Auto-generated method stub
		return null;
	} 
	
}
