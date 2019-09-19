package com.movie.VO;

public class CinemaVO {
	String id;
	String cinema;
	int seat;
	
	public CinemaVO(String id, String cinema, int seat) {
		super();
		this.id = id;
		this.cinema = cinema;
		this.seat = seat;
	}
	public CinemaVO() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCinema() {
		return cinema;
	}
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	
	
	
}
