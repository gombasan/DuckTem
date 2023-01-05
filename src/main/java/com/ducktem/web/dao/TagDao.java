package com.ducktem.web.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.ducktem.web.entity.ProductTag;


@Mapper
public interface TagDao {

	void save(ProductTag productTag);

	List<ProductTag> findByProductId(Long productId);

	


}
