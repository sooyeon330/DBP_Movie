package com.movie.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.VO.MovieVO;
import com.movie.VO.TicketingVO;
import com.movie.mapper.MovieMapper;


@Repository
public class MoiveDAO implements MovieMapper{
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<MovieVO> getAllMovies() {
		List<MovieVO> movies = new ArrayList<MovieVO>();
		return sqlSession.selectList("getAllMovies");
	}

	@Override
	public MovieVO getMovie(String id) {		
		return sqlSession.selectOne("getMovie",id);
	}

	@Override
	public void insertTicket(TicketingVO ticketvo) {
		sqlSession.insert("insertTicket",ticketvo);
	}

	@Override
	public void insertMovie(MovieVO movievo) {
		sqlSession.insert("insertMovie",movievo);
	}

	@Override
	public void deleteMovie(String id) {
		sqlSession.delete("deleteMovie",id);
	}

}
