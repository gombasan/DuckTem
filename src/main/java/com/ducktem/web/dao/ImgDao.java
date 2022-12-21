package com.ducktem.web.dao;


import com.ducktem.web.entity.ProductImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImgDao {

    void save(ProductImg productImg);

    List<ProductImg> findByProductId(Long productId);
}
