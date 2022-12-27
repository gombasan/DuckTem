package com.ducktem.web.dao;

import com.ducktem.web.entity.ProductPreview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProductPreviewDao {

    List<ProductPreview> getPreviewAll();

    List<ProductPreview> findMemberProductList(String memberId);

    List<ProductPreview> getPreviewList(int size, int offset);
}
