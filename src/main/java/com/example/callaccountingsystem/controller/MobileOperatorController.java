package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.MobileOperatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mobileOperator")
public class MobileOperatorController {
    private final MobileOperatorService service;

    public MobileOperatorController(MobileOperatorService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllMobileOperators(Model model) {
        model.addAttribute("mobileOperators", service.getAllMobileOperators());
        return "mobileOperator";
    }
}
