package com.ducktem.web.service;

import com.ducktem.web.entity.Chat;
import com.ducktem.web.entity.ChatRoom;


import java.util.List;

public interface ChattingService {

    List<Chat> getChattingList(ChatRoom chatRoom);


}
