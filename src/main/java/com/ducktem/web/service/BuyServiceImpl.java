package com.ducktem.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducktem.web.dao.BuyDao;
import com.ducktem.web.entity.Buy;
import com.ducktem.web.entity.Product;

@Service
public class BuyServiceImpl implements BuyService{

	@Autowired
	private BuyDao buyDao;
	
	@Override
	public void save( String clientId,Long productId) {
		buyDao.save(clientId, productId);
		
	}
	
//	buy 있는지 확인하는 것
	@Override
	public boolean confirmBuy(String userId, Long productId) {
		
		Buy resultBuy = buyDao.get(userId, productId);
		
		if(resultBuy==null)
			return false;
		else
			return true;
	}

	
//	buy 정보 가져오기
	@Override
	public List<String> get(List<Product> mySellingProduct) {
		List<String> customers = new ArrayList<String>(mySellingProduct.size());
		for(int i=0; i<mySellingProduct.size(); i++) {		
			customers.add(i,buyDao.getCustomer(mySellingProduct.get(i).getId()));
		}
		return customers;
	}

}
