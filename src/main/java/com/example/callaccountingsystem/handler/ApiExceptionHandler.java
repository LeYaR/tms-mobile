package com.example.callaccountingsystem.handler;

import com.example.callaccountingsystem.exception.FieldAlreadyExistException;
import com.example.callaccountingsystem.exception.IllegalPeriodForGeneration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ApiResponse handlerRuntimeException(RuntimeException e) {
        final ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(e.getMessage());
        apiResponse.setCode(400);
        apiResponse.setTimestamp(LocalDateTime.now());
        return apiResponse;
    }

    @ExceptionHandler({FieldAlreadyExistException.class, IllegalPeriodForGeneration.class})
    public ModelAndView handleRuntimeException(Model model, RuntimeException e) {
        final ApiResponse response = new ApiResponse();
        response.setMessage(e.getMessage());
        response.setCode(400);
        response.setTimestamp(LocalDateTime.now());
        model.addAttribute("apiResponse", response);
        return new ModelAndView("exception");
    }

}
