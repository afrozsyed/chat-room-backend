package com.twinkle.chatroom.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MessageResponse {
    private String id;
    private String chatRoomId;
    private String sender;
    private String content;
    private LocalDateTime timestamp;
}
