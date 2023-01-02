package com.ducktem.web.service;

import java.util.List;

import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.MyPageReview;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.entity.Review;

public interface ReviewService {

	void save(String userId, Long productId);

	List<MyPageReview> getmyList(List<Member> customerInfo, List<Product> mySellingProduct);

}
