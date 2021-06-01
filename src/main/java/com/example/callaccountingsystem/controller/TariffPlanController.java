package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.TariffPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tariff-plan")
public class TariffPlanController {
    private final TariffPlanService service;

    public TariffPlanController(TariffPlanService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllTariffPlans(Model model) {
        model.addAttribute("tariffPlans", service.getAllTariffPlans());
        return "tariffPlan";
    }
}
