package com.ducktem.web.service;

import java.util.List;

import com.ducktem.web.entity.Product;

public interface BuyService {

	void save(String clientId,Long productId);

	boolean confirmBuy(String userId, Long productId);

	List<String> get(List<Product> mySellingProduct);
	
	
	
}
