package com.twinkle.chatroom.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private boolean success;
    private String message;
    private String errorCode;
    private LocalDateTime timestamp;
}
