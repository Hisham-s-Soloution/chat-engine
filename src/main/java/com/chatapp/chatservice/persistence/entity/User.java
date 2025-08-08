package com.chatapp.chatservice.persistence.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Field("user_name")
    private String username;

    @Field("email")
    private String email;

    @Field("status")
    // UserStatusEnum
    private Integer status;

    @Field("created_at")
    private LocalDateTime createdAt;
}
