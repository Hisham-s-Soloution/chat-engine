package com.chatapp.chatservice.presentation.Resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersListChatsResponse {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("lastMessage")
    private String lastMessage;

    @JsonProperty("lastMessageTime")
    private LocalDateTime lastMessageTime;

    @JsonProperty("status")
    private Integer status;
}
