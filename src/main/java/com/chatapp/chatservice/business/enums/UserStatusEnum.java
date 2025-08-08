package com.chatapp.chatservice.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatusEnum {
    OFF_LINE(0),
    ON_LINE(1);

    private final Integer value;
}
