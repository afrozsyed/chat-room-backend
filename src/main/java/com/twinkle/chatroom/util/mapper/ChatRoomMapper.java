package com.twinkle.chatroom.util.mapper;

import com.twinkle.chatroom.dto.ChatRoomRequest;
import com.twinkle.chatroom.dto.ChatRoomResponse;
import com.twinkle.chatroom.model.ChatRoom;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ChatRoomMapper {

    public ChatRoom toEntity(ChatRoomRequest request) {
        return new ChatRoom(
                request.getId(),
                request.getName(),
                LocalDateTime.now()
        );
    }

    public ChatRoomResponse toResponse(ChatRoom entity) {
        return ChatRoomResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdAt(entity.getCreationDate())
                .build();
    }
}
