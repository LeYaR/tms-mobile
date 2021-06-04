package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.CurrencyService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllCurrencies(Model model) {
        model.addAttribute("currencies", service.getAllCurrencies());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("currency");
        return modelAndView;
    }
}
