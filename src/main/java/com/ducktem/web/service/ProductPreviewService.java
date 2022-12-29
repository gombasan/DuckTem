package com.ducktem.web.service;

import com.ducktem.web.entity.ProductPreview;

import java.util.List;

public interface ProductPreviewService {

    List<ProductPreview> myList(String memberId);

    List<ProductPreview> preview();

    List<ProductPreview> preview(int page);

    ProductPreview get(Long productId);
}
