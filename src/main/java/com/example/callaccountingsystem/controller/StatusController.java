package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.StatusService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/status")
public class StatusController {

    private final StatusService service;

    public StatusController(StatusService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllStatuses(Model model) {
        model.addAttribute("statuses", service.getAllStatuses());
        return "status";
    }
}
