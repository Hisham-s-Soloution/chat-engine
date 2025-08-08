package com.chatapp.chatservice.business.service;

import com.chatapp.chatservice.persistence.entity.ChatRoom;

import java.util.Optional;

public interface ChatRoomService {
    ChatRoom getOrCreateChatRoom(String userId1, String userId2);
    Optional<ChatRoom> getChatRoom(String userId1, String userId2);
}
