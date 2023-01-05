package com.ducktem.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducktem.web.dao.SearchDao;
import com.ducktem.web.entity.ProductPreview;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;

	@Override
	public List<ProductPreview> getResult(String keyword, String userId) {

		//daoMapper 수정. 걍 getfilteredResult로 통일할 것. 
		List<ProductPreview> result = searchDao.getList(keyword, null, userId);

		return result;
	}

	@Override
	public int getResultCount(String keyword) {

		int count = searchDao.count(keyword);

		return count;
	}

	@Override
	public List<ProductPreview> getfilteredResult(String keyword, String option, String userId) {
		
		List<ProductPreview> list = searchDao.getList(keyword, option, userId);

    	return list;
	}

}
