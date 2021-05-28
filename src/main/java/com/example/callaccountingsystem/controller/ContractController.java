package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    private final ContractService service;

    public ContractController(ContractService service){this.service = service;}

    @GetMapping
    public String viewAllContracts(Model model){
        model.addAttribute("contracts", service.getAllContracts());
        return "contract";
    }
}
