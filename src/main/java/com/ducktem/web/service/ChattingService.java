package com.ducktem.web.service;

import com.ducktem.web.entity.Chat;
import com.ducktem.web.entity.ChatRoom;
import jakarta.servlet.http.HttpServletRequest;


import java.io.File;
import java.util.List;

public interface ChattingService {

    List<Chat> getChattingList(ChatRoom chatRoom, HttpServletRequest request);


}
