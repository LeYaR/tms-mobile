package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.CallService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/call")
public class CallController{

    private final CallService service;

    public CallController(CallService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllCalls(Model model) {
        model.addAttribute("calls", service.getAllCalls());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("call");
        return modelAndView;
    }
}
