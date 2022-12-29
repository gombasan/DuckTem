package com.ducktem.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ducktem.web.entity.WishList;

@Mapper
public interface WishListDao {
	List<WishList> getList(String memberId);

	void save(WishList wishList);

	WishList get(String memberId, Long productId);

	void delete(WishList wishList);

	int getNums(Long productId);

	int getMyWishNum(String userId);
	
}
