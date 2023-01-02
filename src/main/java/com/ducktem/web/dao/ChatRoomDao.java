package com.ducktem.web.dao;


import com.ducktem.web.entity.ChatRoom;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatRoomDao {
    void save(ChatRoom chatRoom);
    ChatRoom findOne(String sellerId, String customerId,Long productId);
}
