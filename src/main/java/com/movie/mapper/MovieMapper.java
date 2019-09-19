package com.movie.mapper;

import java.util.List;

import com.movie.VO.MovieVO;
import com.movie.VO.TicketingVO;

public interface MovieMapper {
	public List<MovieVO> getAllMovies();
	public MovieVO getMovie(String id);
	public void insertMovie(MovieVO movievo);
	public void insertTicket(TicketingVO ticketvo);
	public void deleteMovie(String id);
}
