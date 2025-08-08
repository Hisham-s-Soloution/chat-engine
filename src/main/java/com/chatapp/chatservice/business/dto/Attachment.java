package com.chatapp.chatservice.business.dto;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attachment {

    @Field("url")
    private String url;

    @Field("type")
    private String type;
}
