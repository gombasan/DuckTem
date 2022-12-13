package com.ducktem.web.dao;


import com.ducktem.web.entity.ProductImg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImgDao {

    void save(ProductImg productImg);

}
