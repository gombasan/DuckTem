package com.ducktem.web.service;

public interface WishListService {

	void checkWish(String userId, Long productId);

	void findWish(String userId, Long productId);

	void deleteWish(String userId, Long productId);
	
	
	
	
	
}
