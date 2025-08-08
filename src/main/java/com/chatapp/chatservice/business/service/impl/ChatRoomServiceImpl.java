package com.chatapp.chatservice.business.service.impl;

import com.chatapp.chatservice.business.service.ChatRoomService;
import com.chatapp.chatservice.persistence.entity.ChatRoom;
import com.chatapp.chatservice.persistence.repo.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    @Override
    public ChatRoom getOrCreateChatRoom(String userId1, String userId2) {
        Optional<ChatRoom> existing = getChatRoom(userId1, userId2);
        if (existing.isPresent()) return existing.get();

        ChatRoom room = ChatRoom.builder()
                .participants(Arrays.asList(userId1, userId2))
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return chatRoomRepository.save(room);
    }

    @Override
    public Optional<ChatRoom> getChatRoom(String userId1, String userId2) {
        return chatRoomRepository.findByParticipantsContainingAndParticipantsContaining(userId1, userId2);
    }
}
