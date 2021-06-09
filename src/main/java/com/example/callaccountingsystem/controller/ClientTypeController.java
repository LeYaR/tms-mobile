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
        final Page<ClientType> clientTypePage = service.getAllClients(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, clientTypePage);
        model.addAttribute("clients", clientTypePage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("client");
        return modelAndView;
    }

    @RequestMapping("client/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("clientEdit");
        mav.addObject("client", service.get(id));
        return mav;
    }

    @RequestMapping(value = "client/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("client") ClientType client) {
        service.save(client);
        return "redirect:/client";
    }

    @RequestMapping("client/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        service.delete(id);
        return "redirect:/client";
    }
}
