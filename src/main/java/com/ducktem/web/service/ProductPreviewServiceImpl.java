package com.ducktem.web.service;

import com.ducktem.web.dao.ProductPreviewDao;
import com.ducktem.web.entity.ProductPreview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductPreviewServiceImpl implements ProductPreviewService {

    @Autowired
    private ProductPreviewDao productPreviewDao;

    @Override
    public List<ProductPreview> myList(String memberId) {
        return productPreviewDao.findMemberProductList(memberId);
    }

    @Override
    public List<ProductPreview> preview() {
        return this.preview(1);
    }

    @Override
    public List<ProductPreview> preview(int page) {
        int size = 10;
        int offset = (page-1)*size;



        return productPreviewDao.getPreviewList(size,offset);
    }
}
