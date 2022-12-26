package com.ducktem.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ducktem.web.entity.WishList;

@Mapper
public interface WishListDao {
	void save(WishList wishList);

	void get(WishList wishList);

	void delete(WishList wishList);
	
}
