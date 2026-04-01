package com.twinkle.chatroom.dto;

import lombok.Data;

@Data
public class MessageRequest {
//    @NotBlank(message = "ChatRoom ID is required")
    private String chatRoomId;

//    @NotBlank(message = "Sender is required")
    private String sender;

//    @NotBlank(message = "Message content cannot be empty")
//    @Size(max = 500, message = "Message too long")
    private String content;
}
