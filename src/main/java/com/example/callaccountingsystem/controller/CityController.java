package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
public class CityController {

    private final CityService service;

    public CityController(CityService service){this.service = service;}

    @GetMapping
    public String viewAllCities(Model model){
        model.addAttribute("cities", service.getAllCity());
        return "city";
    }
}
