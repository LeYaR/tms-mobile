package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.CallServiceInterface;
import com.example.callaccountingsystem.service.GenerationServiceInterface;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    private final GenerationServiceInterface generationService;
    private final CallServiceInterface callServiceInterface;

    public HomeController(GenerationServiceInterface generationService, CallServiceInterface callServiceInterface) {
        this.generationService = generationService;
        this.callServiceInterface = callServiceInterface;
    }

    @GetMapping(value = "/home")
    public ModelAndView showForm(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }


    public void generate(Model model) {
        generationService.generate();
    }
}
