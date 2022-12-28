package com.ducktem.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.dao.ProductDao;
import com.ducktem.web.dao.WishListDao;
import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.WishList;

@Service
public class WishListServiceImpl implements WishListService{

    @Autowired
    private ProductDao productDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private WishListDao wishListDao;
    
//    my wishList 불러오기
    @Override
    public List<WishList> findWish(String userId) {
		return wishListDao.getList(userId);
		
    }
    
//    wishList 클릭-저장 서비스
	@Override
	public void checkWish(String userId, Long productId) {	
		
		WishList wishList =  new WishList(productId,userId);
		
        wishListDao.save(wishList);
		
	}

	@Override
	public void deleteWish(String userId, Long productId) {
		
		WishList wishList =  new WishList(productId,userId);
		
        wishListDao.delete(wishList);
		
		
	}

	@Override
	public boolean confirmWish(String userId, Long productId) {
		
		WishList resultWishList = wishListDao.get(userId, productId);
		
		System.out.println(resultWishList);
		if(resultWishList==null)
			return false;
		else
			return true;
	}

	@Override
	public int getWIshNums(Long productId) {
		int nums = wishListDao.getNums(productId);
		return nums;
	}


	
}
