package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.AddressService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService service;

    public AddressController(AddressService service) {this.service = service;}

    @GetMapping
    public ModelAndView viewAllAddresses(Model model){
        model.addAttribute("addresses", service.getAllAddress());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("address");
        return modelAndView;
    }
}


