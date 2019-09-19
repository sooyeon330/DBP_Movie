package com.movie.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.VO.TicketInfoVO;
import com.movie.VO.TicketingVO;
import com.movie.mapper.TicketingMapper;

@Repository
public class TicketingDAO implements TicketingMapper{
	@Autowired
	SqlSession sqlSession;

	@Override
	public TicketInfoVO getTicket(String ticektid) {
		
		return sqlSession.selectOne("getTicket",ticektid);
	}

	@Override
	public void deleteTicket(String ticektid) {
		sqlSession.delete("deleteTicket", ticektid);
	}

	
	
}
