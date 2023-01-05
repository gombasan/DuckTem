package com.ducktem.web.chatting.handler;


import com.ducktem.web.dao.ChatRoomDao;
import com.ducktem.web.dao.ProductDao;
import com.ducktem.web.entity.Chat;
import com.ducktem.web.entity.ChatRoom;
import com.ducktem.web.entity.DucktemUserDetails;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class ChattingHandler extends TextWebSocketHandler {
    private Map<String,WebSocketSession> userSessions = new HashMap<>();
    @Autowired
    private ChatRoomDao chatRoomDao;

    @Autowired
    private ProductDao productDao;


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String loginMember = getMemberId(session);
        if(loginMember != null)
            userSessions.put(getMemberId(session), session);
    }

    private String getMemberId(WebSocketSession session) {
        Map<String, Object> attributes = session.getAttributes();

        SecurityContext securityContext = (SecurityContext) attributes.get("SPRING_SECURITY_CONTEXT");
        String memberId = null;
        if(securityContext != null) {
            DucktemUserDetails principal = (DucktemUserDetails) securityContext.getAuthentication().getPrincipal();
            memberId = principal.getUsername();
        }

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

        // 보낸사람:채팅내용:보낸시간
        ChatRoom chatRoom = chatRoomDao.findOne(sellerId, customerId,productId);

        String chatMsg = chatRequest[3];
        String senderId = getMemberId(session); // 현재 세션 아이디가 보내는 사람.
        if(chatMsg != null) {
            saveChatMsg(chatRoom,senderId,chatMsg);
        }

        WebSocketSession sender = userSessions.get(senderId);
        WebSocketSession seller = userSessions.get(sellerId);
        WebSocketSession customer = userSessions.get(customerId);
        if(sender.equals(seller) && customer != null) {
            customer.sendMessage(new TextMessage(chatMsg));
        }
        else if (sender.equals(customer) && seller != null) {
            seller.sendMessage(new TextMessage(chatMsg));
        }

    }




    public void saveChatMsg(ChatRoom chatRoom,String senderId,String chatMsg) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.now();  //현재 시간
        DateTimeFormatter regTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // 시간 포맷팅 변경
        String regDate = localDateTime.format(regTimeFormat); // 채팅을 보낸 시간.

        // 채팅을 보낸사람, 메세지, 등록일자로 생성 한 후 json 형태로 파일로 저장
        ObjectMapper mapper = new ObjectMapper();
        Chat chat = new Chat(senderId,chatMsg,regDate);
        File file = new File(System.getProperty("user.dir")+"/chattings"+chatRoom.getChatting());
        // 파일이 존재하지 않는 경우 구조를 잡기 위한 생성.
        if(!file.exists()) {
            List<Chat> structure = new ArrayList<>();
            mapper.writeValue(file,structure);
        }

        // json 형태로 저장되어있는 파일을 읽은 후 추가 후 다시 저장.
        List<Chat> chats = mapper.readValue(file, new TypeReference<List<Chat>>() {});
        chats.add(chat);
        mapper.writerWithDefaultPrettyPrinter().writeValue(file,chats);
    }

}
