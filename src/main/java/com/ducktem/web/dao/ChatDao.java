package com.ducktem.web.dao;


import com.ducktem.web.entity.Chat;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatDao {
    void save(Chat chat);
}
