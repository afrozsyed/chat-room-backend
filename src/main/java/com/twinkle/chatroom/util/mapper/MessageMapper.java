package com.twinkle.chatroom.util.mapper;

import com.twinkle.chatroom.dto.MessageRequest;
import com.twinkle.chatroom.dto.MessageResponse;
import com.twinkle.chatroom.model.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageMapper {
    public Message toEntity(MessageRequest request) {
        return new Message(
                null,
                request.getChatRoomId(),
                request.getSender(),
                request.getContent(),
                LocalDateTime.now()
        );
    }

    public MessageResponse toResponse(Message message) {
        return MessageResponse.builder()
                .id(message.getId())
                .chatRoomId(message.getChatRoomId())
                .sender(message.getSender())
                .content(message.getContent())
                .timestamp(message.getTimestamp())
                .build();
    }
}
