package com.movie.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.movie.VO.CinemaVO;
import com.movie.VO.MovieVO;
import com.movie.mapper.CinemaMapper;

@Repository
public class CinemaDAO implements CinemaMapper{
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<CinemaVO> getAllCinemas() {
		List<CinemaVO> cinemas = new ArrayList<CinemaVO>();
		return sqlSession.selectList("getAllCinemas");
	}

	@Override
	public CinemaVO getCinema(String id) {
		return sqlSession.selectOne("getCinema",id);
	}
	
	
	/*
	 * JdbcTemplate template; DataSource datasource;
	 * 
	 * public CinemaDAO() { this.template = StaticTemplate.template; }
	 * 
	 * public ArrayList<CinemaVO> cinemalist() { ArrayList<CinemaVO> cvos = new
	 * ArrayList<CinemaVO>();
	 * 
	 * String sql = "select id, cinema from cinema";
	 * 
	 * cvos = (ArrayList<CinemaVO>) template.query(sql, new
	 * BeanPropertyRowMapper<CinemaVO>(CinemaVO.class));
	 * 
	 * return cvos;
	 * 
	 * }//cinemalist()
	 * 
	 * public ArrayList<MovieVO> movielist() { ArrayList<MovieVO> mvos = new
	 * ArrayList<MovieVO>();
	 * 
	 * String sql = "select id, title, grade, opendate from movie";
	 * 
	 * mvos = (ArrayList<MovieVO>) template.query(sql, new
	 * BeanPropertyRowMapper<MovieVO>(MovieVO.class));
	 * 
	 * return mvos;
	 * 
	 * }//movielist()
	 */
}
