package com.ducktem.web.service;

import java.util.List;

import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;

public interface SearchService {
	
    /* 검색어 입력시 해당 상품 리스트 조회*/
	List<ProductPreview> getResult(String keyword);

	/*검색어 결과 갯수 조회*/
	int getResultCount(String keyword);
	

}
