package com.twinkle.chatroom.service;

import com.twinkle.chatroom.dto.ChatRoomRequest;
import com.twinkle.chatroom.dto.ChatRoomResponse;
import com.twinkle.chatroom.dto.CreateRoomRequest;
import com.twinkle.chatroom.model.ChatRoom;
import com.twinkle.chatroom.repository.ChatRoomRepository;
import com.twinkle.chatroom.util.exceptions.customexceptions.BadRequestException;
import com.twinkle.chatroom.util.exceptions.customexceptions.ResourceNotFoundException;
import com.twinkle.chatroom.util.mapper.ChatRoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomMapper mapper;

    public ChatRoomResponse getRoom(String id){
        System.out.println("ChatRoomService.getRoom Getting room with id " + id);
        ChatRoom room = chatRoomRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Chat room with id " + id + " not found"));
        System.out.println("Fetched ChatRoom " + room);
        return mapper.toResponse(room);
    }

    public ChatRoomResponse createRoom(ChatRoomRequest request) {
        System.out.println("ChatRoomService.createRoom " + request);
        if(chatRoomRepository.existsById(request.getId())) {
            throw new BadRequestException("Chat room already exists");
        }
        ChatRoom room = mapper.toEntity(request);
        return mapper.toResponse(chatRoomRepository.save(room));
    }
}
