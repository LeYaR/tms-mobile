package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.CityService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityService service;

    public CityController(CityService service){this.service = service;}

    @GetMapping
    public ModelAndView viewAllCities(Model model){
        model.addAttribute("cities", service.getAllCity());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("city");
        return modelAndView;
    }
}
