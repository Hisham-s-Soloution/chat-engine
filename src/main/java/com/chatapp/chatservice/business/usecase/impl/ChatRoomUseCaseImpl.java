package com.chatapp.chatservice.business.usecase.impl;

import com.chatapp.chatservice.business.service.ChatRoomService;
import com.chatapp.chatservice.business.service.MessageService;
import com.chatapp.chatservice.business.service.UserService;
import com.chatapp.chatservice.business.usecase.ChatRoomUseCase;
import com.chatapp.chatservice.persistence.entity.ChatRoom;
import com.chatapp.chatservice.persistence.entity.Message;
import com.chatapp.chatservice.persistence.entity.User;
import com.chatapp.chatservice.presentation.Resp.UsersListChatsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatRoomUseCaseImpl implements ChatRoomUseCase {

    private final UserService userService;
    private final ChatRoomService chatRoomService;
    private final MessageService messageService;

    @Override
    public List<UsersListChatsResponse> getUserList() {
        List<User> allUsers = userService.getAll();
        String currentUserId = "6895ef8a1ffc9deee2084ae6";
        return allUsers.stream()
                .filter(u -> !u.getId().equals(currentUserId))
                .map(user -> {
                    Optional<ChatRoom> chatRoomOpt =
                            chatRoomService.findByParticipantsContainingAndParticipantsContaining(
                                    currentUserId, user.getId()
                            );


                    if (chatRoomOpt.isPresent()) {
                        ChatRoom chatRoom = chatRoomOpt.get();
                        Message lastMessage = messageService.findFirstByRoomIdOrderByTimestampDesc(chatRoom.getId())
                                .orElse(null);

                        return UsersListChatsResponse.builder()
                                .userName(user.getUsername())
                                .lastMessage((lastMessage != null) ? lastMessage.getContent() : null)
                                .userId(user.getId())
                                .status(1)
                                .lastMessageTime((lastMessage != null) ? lastMessage.getTimestamp() : null)
                                .build();
                    }


                    return UsersListChatsResponse.builder()
                            .userId(user.getId())
                            .status(1)
                            .userName(user.getUsername())
                            .build();
                })
                .toList();
    }
}
