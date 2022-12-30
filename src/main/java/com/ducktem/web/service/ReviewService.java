package com.ducktem.web.service;

import java.util.List;

import com.ducktem.web.entity.Review;

public interface ReviewService {

	List<Review> getmyList(String userId);

	void save(String userId);

}
