package com.chatapp.chatservice.persistence.entity;

import com.chatapp.chatservice.business.dto.LastMessageInfo;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("chat_rooms")
public class ChatRoom {
    @Id
    private String id;

    @Field(name = "participants")
    @Indexed
    private List<String> participants;

    @Field(name = "last_message")
    private LastMessageInfo lastMessage;

    @Field(name = "created_at")
    private LocalDateTime createdAt;

    @Field(name = "updated_at")
    private LocalDateTime updatedAt;


}
