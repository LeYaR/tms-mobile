package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.PricingUnitService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/pricing-unit")
public class PricingUnitController {

    private final PricingUnitService service;

    public PricingUnitController(PricingUnitService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllPricingUnits(Model model) {
        model.addAttribute("pricingUnits", service.getAllPricingUnits());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pricingUnit");
        return modelAndView;
    }
}
