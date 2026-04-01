package com.twinkle.chatroom.service;

import com.twinkle.chatroom.dto.MessageRequest;
import com.twinkle.chatroom.dto.MessageResponse;
import com.twinkle.chatroom.model.Message;
import com.twinkle.chatroom.repository.MessageRepository;
import com.twinkle.chatroom.util.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final MessageMapper mapper;

    public MessageResponse save(MessageRequest request) {
        Message message = mapper.toEntity(request);
        return mapper.toResponse(messageRepository.save(message));
    }

    public List<MessageResponse> getMessages(String chatRoomId) {
        return messageRepository.findByChatRoomIdOrderByTimestampAsc(chatRoomId).stream().map(mapper::toResponse).toList();
    }
}
