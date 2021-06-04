package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.PassportService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/passport")
public class PassportController {

    private final PassportService service;

    public PassportController(PassportService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllPassports(Model model) {
        model.addAttribute("passports", service.getAllPassports());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passport");
        return modelAndView;
    }
}
