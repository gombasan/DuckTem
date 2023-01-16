package com.ducktem.web.chatting;


import com.ducktem.web.chatting.handler.ChattingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;


@Configuration
@EnableWebSocket
public class ChattingWebSocketConfigure implements WebSocketConfigurer {

    @Autowired
    private  ChattingHandler chattingHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(chattingHandler, "/chatting/start").setAllowedOrigins("*")
                .addInterceptors(new HttpSessionHandshakeInterceptor()); // httpsession을 websocket 핸드셰이크 과정에서 가져와주는 역할?
    }
}
