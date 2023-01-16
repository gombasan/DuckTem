package com.ducktem.web.dao;

import com.ducktem.web.entity.ProductPreview;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ProductPreviewDao {

    List<ProductPreview> getPreviewAll();

    List<ProductPreview> findMemberProductList(String memberId, String myUserId);

    List<ProductPreview> getPreviewList(int size, int offset, String memberId);

    ProductPreview findByProductId(Long productId);

	List<ProductPreview> findPreviewListByCategory(Integer superCategoryId, Integer categoryId, String memberId);

	List<ProductPreview> getWishPreviewList(String memberId);

}
