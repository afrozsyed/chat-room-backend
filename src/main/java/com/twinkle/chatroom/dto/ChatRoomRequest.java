package com.twinkle.chatroom.dto;

import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChatRoomRequest {
    @NotBlank(message = "Chat room id is required")
    private String id;

    @NotBlank(message = "Chat room name is required")
    private String name;
}
