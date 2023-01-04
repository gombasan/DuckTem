package com.ducktem.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducktem.web.dao.TagDao;
import com.ducktem.web.entity.ProductTag;

import jakarta.servlet.http.HttpServletRequest;



@Service
public class TagServiceImpl implements TagService{
	
	@Autowired
	private TagDao tagDao;

	
	/* 상품 태그 등록 서비스*/
	@Override
	public void upload(String[] name, Long productId, byte ban, HttpServletRequest request) {
		ProductTag productTag = new ProductTag();
		productTag.setName(name);
		productTag.setProductId(productId);
		productTag.setBan((byte)1);
		tagDao.save(productTag);
	}



	
	 


}
