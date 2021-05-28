package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.PricingUnitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pricingUnit")
public class PricingUnitController {

    private final PricingUnitService service;

    public PricingUnitController(PricingUnitService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllPricingUnits(Model model) {
        model.addAttribute("pricingUnits", service.getAllPricingUnits());
        return "pricingUnit";
    }
}
