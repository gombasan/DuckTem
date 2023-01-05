package com.ducktem.web.service;


import java.util.List;

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
	
		for(String tagName : name) {
			ProductTag productTag = new ProductTag();
			productTag.setName(tagName);
			productTag.setProductId(productId);
			productTag.setBan((byte)0);
			tagDao.save(productTag);
			
		}

		
	}


	@Override
	public List<ProductTag> getList(Long productId) {
		 return tagDao.findByProductId(productId);
	}
	
	


	
	 


}
