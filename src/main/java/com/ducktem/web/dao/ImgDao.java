package com.ducktem.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ducktem.web.entity.ProductImg;

@Mapper
public interface ImgDao {

	// 여기에는 왜 주석이 없나요..?
	void save(ProductImg productImg);

	List<ProductImg> findByProductId(Long productId);
}
