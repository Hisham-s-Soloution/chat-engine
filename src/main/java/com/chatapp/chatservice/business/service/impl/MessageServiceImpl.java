package com.chatapp.chatservice.business.service.impl;

import com.chatapp.chatservice.business.dto.LastMessageInfo;
import com.chatapp.chatservice.business.service.ChatRoomService;
import com.chatapp.chatservice.business.service.MessageService;
import com.chatapp.chatservice.persistence.entity.ChatRoom;
import com.chatapp.chatservice.persistence.entity.Message;
import com.chatapp.chatservice.persistence.repo.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ChatRoomService chatRoomService;


    @Override
    public Message sendMessage(Message message) {
        // Ensure room exists
        ChatRoom room = chatRoomService.getOrCreateChatRoom(
                message.getSenderId(),
                message.getReceiverId()
        );

        message.setRoomId(room.getId());
        message.setTimestamp(LocalDateTime.now());
        message.setSeen(false);

        Message saved = messageRepository.save(message);

        // Update room's lastMessage
        room.setLastMessage(
                LastMessageInfo.builder()
                        .content(message.getContent())
                        .createdAt(message.getTimestamp())
                        .build()
        );
        room.setUpdatedAt(message.getTimestamp());

        chatRoomService.getChatRoom(message.getSenderId(), message.getReceiverId())
                .ifPresent(chatRoomRepository -> chatRoomRepository.setLastMessage(room.getLastMessage()));

        return saved;
    }

    @Override
    public List<Message> getMessagesByRoom(String roomId) {
        return messageRepository.findByRoomIdOrderByTimestampAsc(roomId);
    }

    @Override
    public List<Message> getUnreadMessages(String receiverId) {
        return messageRepository.findByReceiverIdAndSeenFalse(receiverId);
    }

    @Override
    public Optional<Message> findFirstByRoomIdOrderByTimestampDesc(String id) {
        return messageRepository.findFirstByRoomIdOrderByTimestampDesc(id);
    }
}
