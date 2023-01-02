package com.ducktem.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ducktem.web.entity.ProductPreview;

@Mapper
public interface SearchDao {

//	public List<ProductPreview> getList(String keyword);

	public List<ProductPreview> getList(String keyword, String option);

	public int count(String keyword);


}
