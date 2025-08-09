package com.chatapp.chatservice.presentation.controller;

import com.chatapp.chatservice.business.usecase.ChatRoomUseCase;
import com.chatapp.chatservice.presentation.Resp.UsersListChatsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chat-rooms")
@RequiredArgsConstructor
@Slf4j
public class ChatRoomController {

    private final ChatRoomUseCase chatRoomUseCase;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsersListChatsResponse>> usersList(){
        log.info("usersList");
        return ResponseEntity.ok(chatRoomUseCase.getUserList());
    }
}
