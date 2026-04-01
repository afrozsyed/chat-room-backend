package com.twinkle.chatroom.controller;

import com.twinkle.chatroom.dto.ChatRoomRequest;
import com.twinkle.chatroom.dto.ChatRoomResponse;
import com.twinkle.chatroom.service.ChatRoomService;
import com.twinkle.chatroom.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/chatroom")
@RequiredArgsConstructor
public class ChatRoomController {
    private final ChatRoomService service;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ChatRoomResponse>> getRoom(@PathVariable String id) {
        System.out.println("Getting room with id " + id);
        return ResponseEntity.ok(
                ApiResponse.<ChatRoomResponse>builder()
                        .success(true)
                        .message("Chat room fetched successfully")
                        .data(service.getRoom(id))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ChatRoomResponse>> createRoom(@Valid @RequestBody ChatRoomRequest request) {
        return ResponseEntity.ok(
                ApiResponse.<ChatRoomResponse>builder()
                        .success(true)
                        .message("Chat room created successfully")
                        .data(service.createRoom(request))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }
}
