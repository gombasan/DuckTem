package com.ducktem.web.chatting.handler;


import com.ducktem.web.dao.ChatDao;
import com.ducktem.web.dao.ChatRoomDao;
import com.ducktem.web.dao.ProductDao;
import com.ducktem.web.entity.Chat;
import com.ducktem.web.entity.ChatRoom;
import com.ducktem.web.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ChattingHandler extends TextWebSocketHandler {
    private Map<String,WebSocketSession> userSessions = new HashMap<>();

    @Autowired
    private ChatDao chatDao;

    @Autowired
    private ChatRoomDao chatRoomDao;

    @Autowired
    private ProductDao productDao;


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        userSessions.put(getMemberId(session), session);
    }

    private String getMemberId(WebSocketSession session) {
        Map<String, Object> attributes = session.getAttributes();
        String memberId = (String) attributes.get("userId");
        return memberId;
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //판매자ID/구매자ID/상품번호/메시지
        String payload = message.getPayload();

        String[] chatRequest = payload.split("/");
        String sellerId = chatRequest[0];
        String customerId = chatRequest[1];
        Long productId = Long.parseLong(chatRequest[2]);

        ChatRoom chatRoom = chatRoomDao.findBySellerAndCustomer(sellerId, customerId);

//        if (chatRoom == null) {
//            ChatRoom newChatRoom = new ChatRoom(sellerId,customerId,productId);
//            chatRoomDao.save(newChatRoom);
//            chatRoom = newChatRoom;
//        }

        Long chatRoomId = chatRoom.getId();
        String chatMsg = chatRequest[3];
        if(chatMsg != null) {
            Chat chat = new Chat(chatRoomId,chatMsg);
            chatDao.save(chat);
        }
        Product product = productDao.findById(productId);

        WebSocketSession seller = userSessions.get(product.getRegMemberId());
        if(seller != null) {
            seller.sendMessage(new TextMessage(chatMsg));
        }


    }
}
