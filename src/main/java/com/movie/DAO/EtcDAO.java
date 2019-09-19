package com.movie.DAO;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.mapper.EtcMapper;

@Repository
public class EtcDAO implements EtcMapper{
	@Autowired
	SqlSession sqlSession;

	@Override
	public String getUser() {
		
		return sqlSession.selectOne("getUser");
	}

	/*
	 * @Override public String checkLogin(String id, String pw) { return
	 * sqlSession.selectOne("checkLogin"); }
	 */
	@Override
	public String checkLogin(HashMap<String, String> map) {
		return sqlSession.selectOne("checkLogin",map);		
	}

	
}
