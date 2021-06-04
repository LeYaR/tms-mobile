package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.MobileOperatorService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/mobile-operator")
public class MobileOperatorController {

    private final MobileOperatorService service;

    public MobileOperatorController(MobileOperatorService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllMobileOperators(Model model) {
        model.addAttribute("mobileOperators", service.getAllMobileOperators());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mobileOperator");
        return modelAndView;
    }
}
