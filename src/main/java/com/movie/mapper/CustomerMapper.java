package com.movie.mapper;

import java.util.List;

import com.movie.VO.CustomerVO;

public interface CustomerMapper {
	public List<CustomerVO> getAllCustomer();
	public CustomerVO getCustomer(String id);
	public void insertCustomer(CustomerVO customervo);
}
