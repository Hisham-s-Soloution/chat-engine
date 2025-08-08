package com.chatapp.chatservice.persistence.repo;

import com.chatapp.chatservice.persistence.entity.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {
    // Find the room between two users (bidirectional)
    Optional<ChatRoom> findByParticipantsContainingAndParticipantsContaining(String userId1, String userId2);

}
