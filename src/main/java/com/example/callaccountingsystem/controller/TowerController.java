package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.TowerService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/tower")
public class TowerController {

    private final TowerService service;

    public TowerController(TowerService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllTowers(Model model) {
        model.addAttribute("towers", service.getAllTowers());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tower");
        return modelAndView;
    }
}
