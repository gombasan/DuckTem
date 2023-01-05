package com.ducktem.web.service;

import com.ducktem.web.dao.ProductPreviewDao;
import com.ducktem.web.entity.ProductPreview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ProductPreviewServiceImpl implements ProductPreviewService {

    @Autowired
    private ProductPreviewDao productPreviewDao;



    @Override
    public List<ProductPreview> myList(String memberId, String myUserId) {
        List<ProductPreview> memberProductList = productPreviewDao.findMemberProductList(memberId,myUserId);
        dateChange(memberProductList);
        return memberProductList;
    }

    @Override
    public List<ProductPreview> preview(String memberId) {
        return this.preview(1,memberId);
    }

    @Override
    public List<ProductPreview> preview(int page, String memberId) {
        int size = 10;
        int offset = (page-1)*size;
        List<ProductPreview> previewList = productPreviewDao.getPreviewList(size, offset, memberId);
        dateChange(previewList);
        return previewList;
    }

    public static void dateChange(List<ProductPreview> previewList) {

        for(ProductPreview preview : previewList) {
            Date regDate = preview.getRegDate();
            long today = System.currentTimeMillis();

            long sec = (today-regDate.getTime()) / 1000;
            long minute = (today-regDate.getTime()) / 60000;
            long hour = (today-regDate.getTime()) /3600000;
            long days = sec / (24 * 60 * 60);

            if(sec < 60){
                String betweenSec = sec + "초 전";
                preview.setNTimeAgo(betweenSec);
            }else if (minute < 60){
                String betweenMinute = minute + "분 전";
                preview.setNTimeAgo(betweenMinute);
            }else if(hour < 24) {
                String betweenHour = hour + "시간 전";
                preview.setNTimeAgo(betweenHour);
            }else if(days < 30) {
                String betweenDays = days + "일 전";
                preview.setNTimeAgo(betweenDays);
            }
        }

    }

    @Override
	public List<ProductPreview> previewByCategory(Integer superCategoryId, Integer categoryId) {

		return productPreviewDao.findPreviewListByCategory(superCategoryId, categoryId);
	}



    @Override
    public ProductPreview get(Long productId) {
        return productPreviewDao.findByProductId(productId);
    }
}
