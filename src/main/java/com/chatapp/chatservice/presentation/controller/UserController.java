package com.chatapp.chatservice.presentation.controller;

import com.chatapp.chatservice.business.usecase.UserUseCase;
import com.chatapp.chatservice.persistence.entity.User;
import com.chatapp.chatservice.presentation.req.UserCreationRequest;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveNewUser(@RequestBody UserCreationRequest request) throws Exception {
        return ResponseEntity.ok(userUseCase.saveNewRequest(request));
    }
}
