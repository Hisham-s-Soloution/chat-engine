package com.chatapp.chatservice.persistence.repo;

import com.chatapp.chatservice.persistence.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByRoomIdOrderByTimestampAsc(String roomId);

    List<Message> findByReceiverIdAndSeenFalse(String receiverId);

    Long countByRoomIdAndReceiverIdAndSeenFalse(String roomId, String receiverId);
}
