package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Status;
import com.example.callaccountingsystem.service.StatusServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class StatusController {

    private final StatusServiceInterface service;

    public StatusController(StatusServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/status")
    public ModelAndView viewAllStatuses(Model model,
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
        final Page<Status> statusPage = service.getAllStatuses(currentPage, pageSize);
        model.addAttribute("statuses", statusPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("status");
        return modelAndView;
    }

    @GetMapping("/status/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("statusEditing");
        mav.addObject("status", service.get(id));
        return mav;
    }

    @PostMapping("/status/save")
    public ModelAndView save(@ModelAttribute("status") Status status) {
        service.save(status);
        return new ModelAndView("redirect:/status");
    }

}
