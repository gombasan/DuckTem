package com.ducktem.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducktem.web.dao.ReviewDao;
import com.ducktem.web.entity.Review;



@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	
	@Override
	public List<Review> getmyList(String userId) {
		return reviewDao.getReviewList();
	}

	@Override
	public void save(String userId) {
		reviewDao.save();
	}

	
	
	
}
