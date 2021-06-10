package com.example.callaccountingsystem.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ApiResponse handlerRuntimeException(RuntimeException e){
        final ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(e.getMessage());
        apiResponse.setCode(400);
        apiResponse.setTimestamp(LocalDateTime.now());
        return apiResponse;
    }

}
