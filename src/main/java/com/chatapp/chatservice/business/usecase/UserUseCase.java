package com.chatapp.chatservice.business.usecase;

import com.chatapp.chatservice.exceptions.BusinessException;
import com.chatapp.chatservice.persistence.entity.User;
import com.chatapp.chatservice.presentation.req.UserCreationRequest;
import org.apache.coyote.BadRequestException;

public interface UserUseCase {
    User saveNewRequest(UserCreationRequest request) throws BusinessException;
}
