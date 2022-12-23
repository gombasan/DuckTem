//package com.ducktem.web.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ducktem.web.dao.MemberDao;
//import com.ducktem.web.dao.ProductDao;
//import com.ducktem.web.dao.WishListDao;
//import com.ducktem.web.entity.Member;
//import com.ducktem.web.entity.WishList;
//
//@Service
//public class WishListServiceImpl implements WishListService{
//
//    @Autowired
//    private ProductDao productDao;
//    @Autowired
//    private MemberDao memberDao;
//    @Autowired
//    private WishListDao wishListDao;
//	
//    
////    wishList 클릭-저장 서비스
//	@Override
//	public void checkWish(String userId, Long productId) {	
//		
//		WishList wishList =  new WishList(userId, productId);
//		
//        wishListDao.save(wishList);
//		
//	}
//	
//}
