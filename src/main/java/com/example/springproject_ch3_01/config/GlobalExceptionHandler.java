package com.example.springproject_ch3_01.config;

import com.example.springproject_ch3_01.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 커스텀 예외 처리
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex) {

        return ResponseEntity
                .status(ex.getStatus())
                .body(ex.getMessage());
    }
}

