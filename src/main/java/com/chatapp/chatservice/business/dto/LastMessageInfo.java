package com.chatapp.chatservice.business.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LastMessageInfo {

    @Field(name = "content")
    private String content;

    @Field(name = "created_at")
    private LocalDateTime createdAt;
}
