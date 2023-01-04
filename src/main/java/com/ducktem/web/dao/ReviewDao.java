package com.ducktem.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ducktem.web.entity.Review;

@Mapper
public interface ReviewDao {

	void save(Long productId, String memberId);

	Review get(Long productId, String memberId);

}
