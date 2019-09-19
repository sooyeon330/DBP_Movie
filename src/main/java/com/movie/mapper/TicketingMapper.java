package com.movie.mapper;

import com.movie.VO.TicketInfoVO;
import com.movie.VO.TicketingVO;

public interface TicketingMapper {
	public TicketInfoVO getTicket(String ticektid);
	public void deleteTicket(String ticektid);
}
