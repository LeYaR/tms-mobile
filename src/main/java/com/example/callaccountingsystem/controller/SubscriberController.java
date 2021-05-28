package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.SubscriberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subscriber")
public class SubscriberController {

    private final SubscriberService service;

    public SubscriberController(SubscriberService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllSubscribers(Model model) {
        model.addAttribute("subscribers", service.getAllSubscribers());
        return "subscriber";
    }
}
