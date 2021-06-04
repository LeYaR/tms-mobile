package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.StatusService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService service;

    public StatusController(StatusService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllStatuses(Model model) {
        model.addAttribute("statuses", service.getAllStatuses());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("status");
        return modelAndView;
    }
}
