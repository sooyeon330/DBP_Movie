package com.movie.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.VO.CustomerVO;
import com.movie.VO.TicketInfoVO;
import com.movie.VO.TicketingVO;
import com.movie.mapper.CustomerMapper;
import com.movie.mapper.TicketingMapper;

@Repository
public class CustomerDAO implements CustomerMapper{
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<CustomerVO> getAllCustomer() {
		
		return sqlSession.selectList("getAllCustomers");
	}

	@Override
	public CustomerVO getCustomer(String id) {
		
		return sqlSession.selectOne("getCustomer",id);
	}

	@Override
	public void insertCustomer(CustomerVO customervo) {
		sqlSession.insert("insertCustomer",customervo);
	}


	
	
}
