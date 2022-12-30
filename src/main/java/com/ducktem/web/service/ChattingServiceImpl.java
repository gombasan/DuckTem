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
    private ChatDao chatDao;

    @Autowired
    private ChatRoomDao chatRoomDao;

    @Override
    public List<Chat> getChattingList(ChatRoom chatRoom) {
        Long roomId = 0L;
        ChatRoom existingChatRoom = chatRoomDao.findOne(chatRoom.getSellerId(), chatRoom.getCustomerId(),chatRoom.getProductId());
        if(existingChatRoom == null) {
            chatRoomDao.save(chatRoom);
            roomId = chatRoom.getId();
            return chatDao.findByChatRoomId(roomId);
        }

        roomId = existingChatRoom.getId();
        return chatDao.findByChatRoomId(roomId);
    }
}
