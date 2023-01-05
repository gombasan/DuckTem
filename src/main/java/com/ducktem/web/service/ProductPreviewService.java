package com.ducktem.web.service;

import com.ducktem.web.entity.ProductPreview;

import java.util.List;

public interface ProductPreviewService {

    List<ProductPreview> myList(String memberId, String myUserId);

	List<ProductPreview> preview(String memberId);

	List<ProductPreview> preview(int page, String memberId);

	List<ProductPreview> previewByCategory(Integer superCategoryId, Integer categoryId);

    ProductPreview get(Long productId);



}
