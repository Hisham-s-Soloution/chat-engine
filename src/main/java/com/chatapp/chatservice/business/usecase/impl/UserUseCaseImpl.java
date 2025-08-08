package com.chatapp.chatservice.business.usecase.impl;

import com.chatapp.chatservice.business.service.UserService;
import com.chatapp.chatservice.business.usecase.UserUseCase;
import com.chatapp.chatservice.exceptions.BusinessException;
import com.chatapp.chatservice.persistence.entity.User;
import com.chatapp.chatservice.presentation.req.UserCreationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserUseCaseImpl implements UserUseCase {

    private final UserService userService;

    @Override
    public User saveNewRequest(UserCreationRequest request) throws BusinessException {
        if(
                request == null ||
                        request.getPassword() == null ||
                        request.getPassword().isEmpty() ||
                        request.getUserName() == null ||
                        request.getUserName().isEmpty() ||
                        request.getEmail() == null ||
                        request.getEmail().isEmpty()
        ){
            log.error("Invalid Request, {}", request);
            throw new IllegalArgumentException();
        }
        Optional<User> optionalExistingUser = userService.findByEmailOrUserName(request.getEmail(), request.getUserName());
        if(optionalExistingUser.isPresent()){
            log.error("User with email {}, and name {} already exists", request.getEmail(), request.getUserName());
            throw new BusinessException("User with email " + request.getEmail() + " and name " + request.getUserName() + " already exists", HttpStatus.BAD_REQUEST.value());
        }

        User user = User.builder()
                .email(request.getEmail())
                .username(request.getUserName())
                .build();
        user = userService.createUser(user);
        return user;
    }
}
