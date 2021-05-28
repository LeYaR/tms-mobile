package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.CountryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/country")
public class CountryController {
    private final CountryService service;

    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllCountries(Model model) {
        model.addAttribute("countries", service.getAllCountries());
        return "country";
    }
}
