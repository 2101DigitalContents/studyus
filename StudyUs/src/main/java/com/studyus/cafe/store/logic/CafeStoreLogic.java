package com.studyus.cafe.store.logic;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.studyus.cafe.domain.Cafe;
import com.studyus.cafe.store.CafeStore;

@Repository
public class CafeStoreLogic implements CafeStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ArrayList<Cafe> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cafe selectOne(int caNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCafe(Cafe cafe) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCafe(Cafe cafe) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCafe(int caNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}