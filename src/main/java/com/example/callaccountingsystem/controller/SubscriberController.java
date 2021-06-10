package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Subscriber;
import com.example.callaccountingsystem.service.SubscriberServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class SubscriberController {

    private final SubscriberServiceInterface service;

    public SubscriberController(SubscriberServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/subscriber")
    public ModelAndView viewAllSubscribers(Model model,
                                           @RequestParam("page") Optional<Integer> page,
                                           @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);
        final Page<Subscriber> subscriberPage = service.getAllSubscribers(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, subscriberPage);
        model.addAttribute("subscribers", subscriberPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("subscriber");
        return modelAndView;
    }

    @GetMapping("/subscriber/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("userEditing");
        mav.addObject("subscriber", service.get(id));
        return mav;
    }

    @PostMapping("/subscriber/save")
    public String save(@ModelAttribute("subscriber") Subscriber subscriber) {
        service.save(subscriber);
        return "redirect:/subscriber";
    }

}
