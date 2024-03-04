package com.example.demo.model.user.response;



import com.example.demo.utils.payload.Response;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class LogoutResponse extends Response {
    public LogoutResponse(String message, int code, HttpStatus status, LocalDateTime timestamp) {
        super(message, code, status, timestamp);
    }
}
