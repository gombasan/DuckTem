package com.ducktem.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ducktem.web.entity.Buy;

@Mapper
public interface BuyDao {

	void save(String memberId, Long productId);

	Buy get(String memberId, Long productId);

	String getCustomer(Long prodcutId);

}
