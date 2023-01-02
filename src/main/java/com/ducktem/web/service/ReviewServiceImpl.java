package com.ducktem.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducktem.web.dao.ProductDao;
import com.ducktem.web.dao.ReviewDao;
import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.MyPageReview;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.Review;



@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	@Override
	public void save(String userId, Long productId) {
		reviewDao.save(productId,userId);
	}
	
	@Override
	public List<MyPageReview> getmyList(List<Member> customerInfo, List<Product> mySellingProduct) {
		
		
		List<MyPageReview> myPageReviewList = new ArrayList<>(customerInfo.size());
		
		for(int i=0; i<customerInfo.size(); i++)	{
			if(customerInfo.get(i) != null) {

				Review tempReview = reviewDao.get(mySellingProduct.get(i).getId(),
												  customerInfo.get(i).getUserId());
				
				MyPageReview tempMyPageReview = new MyPageReview(
													customerInfo.get(i).getProfileImg(), 
													mySellingProduct.get(i).getName(), 
													customerInfo.get(i).getUserId(), 
													tempReview.getContent(), 
													tempReview.getRegDate());
				
				myPageReviewList.add(i,tempMyPageReview);
			}
					
		}
		return myPageReviewList;
	}


	
	
	
}
