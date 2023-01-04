package com.ducktem.web.service;

import com.ducktem.web.dao.ChatRoomDao;
import com.ducktem.web.entity.Chat;
import com.ducktem.web.entity.ChatRoom;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

@Service
public class ChattingServiceImpl implements ChattingService{

    private final String PATH = System.getProperty("user.dir") + "/chattings";
    @Autowired
    private ChatRoomDao chatRoomDao;

    @Override
    public List<Chat> getChattingList(ChatRoom chatRoom, HttpServletRequest request) {
        Long roomId = 0L;
        String sellerId = chatRoom.getSellerId();
        String customerId = chatRoom.getCustomerId();
        Long productId = chatRoom.getProductId();
        String chatting = chatRoom.getChatting();
        ObjectMapper mapper = new ObjectMapper();

        ChatRoom existingChatRoom = chatRoomDao.findOne(sellerId, customerId, productId);

        if (existingChatRoom == null) {
            chatting = File.separator + "chatting" + "_" + sellerId + "_" + customerId + "_" + productId;
            chatRoom.setChatting(chatting);
            chatRoomDao.save(chatRoom);
            existingChatRoom = chatRoom;
        }

        List<Chat> chats = null;
        try {
            File file = new File(PATH+existingChatRoom.getChatting());
            chats = mapper.readValue(file, new TypeReference<List<Chat>>() {});
        } catch (Exception e) {

        }
        return chats;
    }

}
