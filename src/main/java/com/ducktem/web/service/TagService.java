package com.ducktem.web.service;

import java.util.List;

import com.ducktem.web.entity.ProductTag;

import jakarta.servlet.http.HttpServletRequest;

public interface TagService {
	
	void upload(String[] name, Long productId, byte ban , HttpServletRequest request);

	List<ProductTag> getList(Long productId);

	
	
}
