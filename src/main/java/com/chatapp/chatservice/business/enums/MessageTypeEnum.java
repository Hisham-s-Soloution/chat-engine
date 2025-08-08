package com.chatapp.chatservice.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageTypeEnum {
    TEXT(1),
    IMAGE(2),
    AUDIO(3),
    VIDEO(4),
    FILE(5);

    private final Integer value;
}
