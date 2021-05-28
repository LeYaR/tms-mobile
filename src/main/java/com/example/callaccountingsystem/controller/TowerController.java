package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.TowerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tower")
public class TowerController {

    private final TowerService service;

    public TowerController(TowerService service) {
        this.service = service;
    }

    @GetMapping
    public String viewAllTowers(Model model) {
        model.addAttribute("towers", service.getAllTowers());
        return "tower";
    }
}
