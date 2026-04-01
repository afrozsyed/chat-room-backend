package com.twinkle.chatroom.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ChatRoomResponse {
    private String id;
    private String name;
    private LocalDateTime createdAt;
}
