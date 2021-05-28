package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/address")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {this.service = service;}

    @GetMapping
    public String viewAllAddresses(Model model){
        model.addAttribute("addresses", service.getAllAddress());
        return "address";
    }
}


