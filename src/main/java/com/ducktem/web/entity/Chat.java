package com.ducktem.web.entity;


import java.util.Date;

public class Chat {
    private Long chatRoomId;
    private String chat;

    private Date regDate;

    public Chat() {
        this(null, null);
    }

    public Chat(Long chatRoomId, String chat) {
        this.chatRoomId = chatRoomId;
        this.chat = chat;
    }

    public Long getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
