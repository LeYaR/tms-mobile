package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.PassportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/passport")
public class PassportController {
    private final PassportService service;

    public PassportController(PassportService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllPassports(Model model) {
        model.addAttribute("passports", service.getAllPassports());
        return "passport";
    }
}
