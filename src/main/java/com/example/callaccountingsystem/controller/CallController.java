package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.CallService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/call")
public class CallController{

    private final CallService service;

    public CallController(CallService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllCalls(Model model) {
        model.addAttribute("calls", service.getAllCalls());
        return "call";
    }

}
