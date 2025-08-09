package com.chatapp.chatservice.persistence.repo;

import com.chatapp.chatservice.persistence.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByRoomIdOrderByTimestampAsc(String roomId);
    List<Message> findByReceiverIdAndSeenFalse(String receiverId);
    Long countByRoomIdAndReceiverIdAndSeenFalse(String roomId, String receiverId);
    Optional<Message> findFirstByRoomIdOrderByTimestampDesc(String id);
}
