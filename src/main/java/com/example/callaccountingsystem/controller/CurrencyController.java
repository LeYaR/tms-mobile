package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllCurrencies(Model model) {
        model.addAttribute("currencies", service.getAllCurrencies());
        return "currency";
    }
}
