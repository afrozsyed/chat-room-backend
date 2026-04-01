package com.twinkle.chatroom.controller;

import com.twinkle.chatroom.dto.MessageRequest;
import com.twinkle.chatroom.dto.MessageResponse;
import com.twinkle.chatroom.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {
    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendMessage")
    public void sendMessage(MessageRequest request) {

        System.out.println("ChatWebSocketController.sendMessage"+request.getSender());

        // Save message
        MessageResponse saved = messageService.save(request);

        // Broadcast to room
        messagingTemplate.convertAndSend(
                "/topic/chatroom/" + request.getChatRoomId(),
                saved
        );
    }
}
