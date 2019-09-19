package com.movie.mapper;

import java.util.List;

import com.movie.VO.CinemaVO;

public interface CinemaMapper {
	public List<CinemaVO> getAllCinemas();
	public CinemaVO getCinema(String id);
}
