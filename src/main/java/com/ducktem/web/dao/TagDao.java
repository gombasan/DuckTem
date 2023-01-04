package com.ducktem.web.dao;



import org.apache.ibatis.annotations.Mapper;


import com.ducktem.web.entity.ProductTag;


@Mapper
public interface TagDao {

	void save(ProductTag productTag);

	


}
