package com.twinkle.chatroom.util.exceptions;

import com.twinkle.chatroom.util.ApiError;
import com.twinkle.chatroom.util.exceptions.customexceptions.BadRequestException;
import com.twinkle.chatroom.util.exceptions.customexceptions.ResourceNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiError.builder()
                        .success(false)
                        .message(ex.getMessage())
                        .errorCode("NOT_FOUND")
                        .timestamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException ex) {
        return ResponseEntity.badRequest()
                .body(ApiError.builder()
                        .success(false)
                        .message(ex.getMessage())
                        .errorCode("BAD_REQUEST")
                        .timestamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
        String error = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();

        return ResponseEntity.badRequest()
                .body(ApiError.builder()
                        .success(false)
                        .message(error)
                        .errorCode("VALIDATION_ERROR")
                        .timestamp(LocalDateTime.now())
                        .build());
    }
}
