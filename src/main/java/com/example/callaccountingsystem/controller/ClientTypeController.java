package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.ClientTypeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/client")
public class ClientTypeController {

    private final ClientTypeService service;

    public ClientTypeController(ClientTypeService service){this.service = service;}

    @GetMapping
    public ModelAndView viewClientsType(Model model){
        model.addAttribute("clients", service.getAllClients());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("client");
        return modelAndView;
    }
}
