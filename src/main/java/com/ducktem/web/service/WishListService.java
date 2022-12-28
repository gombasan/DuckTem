package com.ducktem.web.service;

import java.util.List;

import com.ducktem.web.entity.WishList;

public interface WishListService {

	void checkWish(String userId, Long productId);

	List<WishList> findWish(String userId);

	boolean confirmWish(String userId, Long productId);

	void deleteWish(String userId, Long productId);

	int getWIshNums(Long productId);
	
}
