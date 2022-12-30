package com.ducktem.web.entity;


import java.util.Date;

public class Chat {
    private Long id;
    private Long chatRoomId;
    private String content;

    private int readChat;
    private Date regDate;

    public Chat() {
        this(null, null);
    }

    public Chat(Long chatRoomId, String content) {
        this.chatRoomId = chatRoomId;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getReadChat() {
        return readChat;
    }

    public void setReadChat(int readChat) {
        this.readChat = readChat;
    }

    public Long getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getChat() {
        return content;
    }

    public void setChat(String chat) {
        this.content = chat;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
