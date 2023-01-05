package com.ducktem.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ducktem.web.dao.ImgDao;
import com.ducktem.web.dao.MemberDao;
import com.ducktem.web.dao.ProductDao;
import com.ducktem.web.dao.ProductPreviewDao;
import com.ducktem.web.dao.WishListDao;
import com.ducktem.web.entity.Member;
import com.ducktem.web.entity.Product;
import com.ducktem.web.entity.ProductImg;
import com.ducktem.web.entity.ProductPreview;
import com.ducktem.web.entity.WishList;

@Service
public class WishListServiceImpl implements WishListService{

    @Autowired
    private ProductDao productDao;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private WishListDao wishListDao;
    @Autowired
    private ProductPreviewDao productPreviewDao;
    
    @Autowired
    private ImgDao imgDao;
    
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
//	위시 있는지 확인하는 것
	@Override
	public boolean confirmWish(String userId, Long productId) {
		
		WishList resultWishList = wishListDao.get(userId, productId);
		
		System.out.println(resultWishList);
		if(resultWishList==null)
			return false;
		else
			return true;
	}
// 프로덕트 아이디로 불러오기
	@Override
	public int getWIshNumsbyPId(Long productId) {
		int nums = wishListDao.getNums(productId);
		return nums;
	}

	@Override
	public List<ProductPreview> getmyWishList(String memberId) {
//		for(int i=0; i<wishList.size() ; i++) {
//			Long tempProdcutId = wishList.get(i).getProductId();
//			Product tempProduct = productDao.findById(tempProdcutId);
//			List<ProductImg> tempProductImgList = imgDao.findByProductId(tempProdcutId);
//			
//			ProductPreview tempPreview = new ProductPreview(
//												tempProductImgList.get(0).getName(),
//												tempProduct.getPrice(),
//												tempProduct.getName(),
//												wishList.get(i).getRegDate().toString()); 
//			
//			tempPreview.setProductId(tempProdcutId);
//			myWishList.add(i,tempPreview);
//		}
		

		return productPreviewDao.getWishPreviewList(memberId);

	}

	@Override
	public int getMyWishNum(String userId) {
		return wishListDao.getMyWishNum(userId);
	}

	@Override
	public String getStatus(String userId, Long productId) {
		
		return wishListDao.getStatus(userId, productId);
	}


	
}
