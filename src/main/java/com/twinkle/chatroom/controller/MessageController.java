package com.twinkle.chatroom.controller;

import com.twinkle.chatroom.dto.MessageResponse;
import com.twinkle.chatroom.model.Message;
import com.twinkle.chatroom.service.MessageService;
import com.twinkle.chatroom.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService service;

    @GetMapping("/{chatRoomId}")
    public ResponseEntity<ApiResponse<List<MessageResponse>>> getMessages(@PathVariable String chatRoomId) {
        return ResponseEntity.ok(
                ApiResponse.<List<MessageResponse>>builder()
                        .success(true)
                        .message("Messages fetched successfully")
                        .data(service.getMessages(chatRoomId))
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

}
