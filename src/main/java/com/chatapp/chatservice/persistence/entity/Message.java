package com.chatapp.chatservice.persistence.entity;

import com.chatapp.chatservice.business.dto.Attachment;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "messages")
public class Message {

    @Id
    private String id;

    @Indexed
    private String roomId;

    @Field(name = "sender_id")
    private String senderId;

    @Field(name = "receiver_id")
    private String receiverId;

    @Field(name = "content")
    private String content;

    @Field(name = "message_type")
    // MessageTypeEnum
    private Integer messageType;

    @Field(name = "seen")
    private Boolean seen;

    @Field(name = "deleted_for")
    private List<String> deletedFor; // List of user IDs who "deleted" it

    @Field(name = "attachment")
    private Attachment attachment;

    @Field(name = "timestamp")
    private LocalDateTime timestamp;
}
