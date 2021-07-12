package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.ClientType;
import com.example.callaccountingsystem.service.ClientTypeServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class ClientTypeController {

    private final ClientTypeServiceInterface service;

    public ClientTypeController(ClientTypeServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/client")
    public ModelAndView viewClientsType(Model model,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);
        int quantityPage = service.getQuantityPages(pageSize);
        if(currentPage > quantityPage || currentPage < 1){
            return new ModelAndView("redirect:/tables");
        }
        model.addAttribute("quantityPage", quantityPage);
        model.addAttribute("numberPage", currentPage);
        final Page<ClientType> clientTypePage = service.getAllClients(currentPage, pageSize);
        model.addAttribute("clients", clientTypePage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("client");
        return modelAndView;
    }

    @GetMapping("/client/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("clientEditing");
        mav.addObject("client", service.get(id));
        return mav;
    }

    @PostMapping(value = "/client/save")
    public ModelAndView save(@ModelAttribute("client") ClientType client) {
        service.save(client);
        return new ModelAndView("redirect:/client");    }

}
