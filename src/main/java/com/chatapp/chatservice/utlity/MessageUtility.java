package com.chatapp.chatservice.utlity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Component;

import java.util.Locale;

@RequiredArgsConstructor
@Component
@Slf4j
public class MessageUtility {
    private final MessageSource messageSource;

    public String get(String key) {
        return get(key, null, Locale.getDefault());
    }

    public String get(String key, Locale locale) {
        return get(key, null, locale);
    }

    public String get(String key, Object[] args, Locale locale) {
        return messageSource.getMessage(key, args, locale != null ? locale : Locale.getDefault());
    }

}
