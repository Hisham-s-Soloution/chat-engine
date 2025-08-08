package com.chatapp.chatservice.presentation.controller;

import com.chatapp.chatservice.business.usecase.ChatUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final ChatUseCase chatUseCase;
    private final SimpMessagingTemplate messagingTemplate;


//    @MessageMapping("/chat") // Handles messages sent to /app/chat
//    @SendTo("/topic/messages") // Sends to subscribers on /topic/messages
//    public ChatMessageResponse handleMessage(ChatMessage message) {
//        message.setTimestamp(String.valueOf(System.currentTimeMillis()));
//        return message;
//    }
}
