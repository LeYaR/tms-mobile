package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.SubscriberService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/subscriber")
public class SubscriberController {

    private final SubscriberService service;

    public SubscriberController(SubscriberService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllSubscribers(Model model) {
        model.addAttribute("subscribers", service.getAllSubscribers());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("subscriber");
        return modelAndView;
    }
}
