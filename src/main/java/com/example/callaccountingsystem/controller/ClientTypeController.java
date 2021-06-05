package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.ClientType;
import com.example.callaccountingsystem.service.ClientTypeServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientTypeController {

    private final ClientTypeServiceInterface service;

    public ClientTypeController(ClientTypeServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewClientsType(Model model, @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        final Page<ClientType> clientTypePage = service.getAllClients(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, clientTypePage);
        model.addAttribute("clients", clientTypePage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("client");
        return modelAndView;
    }
}
