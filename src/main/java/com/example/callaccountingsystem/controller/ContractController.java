package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.ContractService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/contract")
public class ContractController {

    private final ContractService service;

    public ContractController(ContractService service){this.service = service;}

    @GetMapping
    public ModelAndView viewAllContracts(Model model){
        model.addAttribute("contracts", service.getAllContracts());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contract");
        return modelAndView;
    }
}
