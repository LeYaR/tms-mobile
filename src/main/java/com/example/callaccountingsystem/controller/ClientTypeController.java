package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.service.ClientTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientTypeController {

    private final ClientTypeService service;

    public ClientTypeController(ClientTypeService service){this.service = service;}

    @GetMapping
    public String viewClientsType(Model model){
        model.addAttribute("clients", service.getAllClients());
        return "client";
    }
}
