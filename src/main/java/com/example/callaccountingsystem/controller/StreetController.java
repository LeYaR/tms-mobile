package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.StreetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/street")
public class StreetController {

    private final StreetService service;

    public StreetController(StreetService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllStreets(Model model) {
        model.addAttribute("streets", service.getAllStreets());
        return "street";
    }
}
