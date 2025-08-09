package com.chatapp.chatservice.business.usecase;

import com.chatapp.chatservice.presentation.Resp.UsersListChatsResponse;

import java.util.List;

public interface ChatRoomUseCase {
    List<UsersListChatsResponse> getUserList();
}
