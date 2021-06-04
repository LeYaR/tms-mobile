package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.TariffPlanService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/tariff-plan")
public class TariffPlanController {

    private final TariffPlanService service;

    public TariffPlanController(TariffPlanService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllTariffPlans(Model model) {
        model.addAttribute("tariffPlans", service.getAllTariffPlans());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tariffPlan");
        return modelAndView;
    }
}
