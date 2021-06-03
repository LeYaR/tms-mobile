package com.example.callaccountingsystem.handler;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Data
@ResponseBody
public class ApiResponse {
    private String message;
    private int code;
    private LocalDateTime timestamp;
}
