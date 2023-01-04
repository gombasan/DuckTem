package com.ducktem.web.service;

import jakarta.servlet.http.HttpServletRequest;

public interface TagService {

	void upload(String[] name, Long productId, byte ban , HttpServletRequest request);

	
	
}
