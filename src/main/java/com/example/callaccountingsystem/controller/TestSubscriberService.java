package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import com.example.callaccountingsystem.exception.UserAlreadyExistException;
import com.example.callaccountingsystem.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestSubscriberService {

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping
    public ResponseEntity registration (@RequestBody SubscriberEntity entity){
        try{
            subscriberService.registration(entity);
            return ResponseEntity.ok("Пользователь был успешно сохранён");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getTest() {
        try{
            return ResponseEntity.ok("Сервер работает");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
