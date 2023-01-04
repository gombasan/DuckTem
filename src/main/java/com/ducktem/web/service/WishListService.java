package com.ducktem.web.service;

import java.util.ArrayList;
import java.util.List;

import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.entity.WishList;

public interface WishListService {

	void checkWish(String userId, Long productId);

	List<WishList> findWish(String userId);

	boolean confirmWish(String userId, Long productId);

	void deleteWish(String userId, Long productId);

	int getWIshNumsbyPId(Long productId);

	ArrayList<ProductPreview> getmyWishList(List<WishList> wishList);

	int getMyWishNum(String userId);

	
}
