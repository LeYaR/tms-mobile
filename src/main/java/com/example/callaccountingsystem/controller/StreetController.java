package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.StreetService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/street")
public class StreetController {

    private final StreetService service;

    public StreetController(StreetService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllStreets(Model model) {
        model.addAttribute("streets", service.getAllStreets());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("street");
        return modelAndView;
    }
}
