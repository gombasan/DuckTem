package com.ducktem.web.service;

import com.ducktem.web.dao.ChatDao;
import com.ducktem.web.dao.ChatRoomDao;
import com.ducktem.web.entity.Chat;
import com.ducktem.web.entity.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChattingServiceImpl implements ChattingService{

    @Autowired
    private ChatDao chat;

    @Autowired
    private ChatRoomDao chatRoomDao;

    @Override
    public List<Chat> getChattingList(ChatRoom chatRoom) {
        chatRoomDao.findBySellerAndCustomer(chatRoom.getSellerId(), chatRoom.getCustomerId());


        return null;
    }
}
