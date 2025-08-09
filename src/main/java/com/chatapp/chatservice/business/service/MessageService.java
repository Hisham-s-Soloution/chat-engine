package com.chatapp.chatservice.business.service;

import com.chatapp.chatservice.persistence.entity.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    Message sendMessage(Message message);
    List<Message> getMessagesByRoom(String roomId);
    List<Message> getUnreadMessages(String receiverId);
    Optional<Message> findFirstByRoomIdOrderByTimestampDesc(String id);
}
