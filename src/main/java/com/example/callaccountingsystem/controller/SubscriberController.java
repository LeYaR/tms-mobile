package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Street;
import com.example.callaccountingsystem.domain.dto.Subscriber;
import com.example.callaccountingsystem.service.SubscriberServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/subscriber")
public class SubscriberController {

    private final SubscriberServiceInterface service;

    public SubscriberController(SubscriberServiceInterface service) {
        this.service = service;
    }

    @GetMapping
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

    @RequestMapping("subscriber/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("subscriberEdit");
        mav.addObject("subscriber", service.get(id));
        return mav;
    }

    @RequestMapping(value = "subscriber/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("subscriber") Subscriber subscriber) {
        service.save(subscriber);
        return "redirect:/subscriber";
    }

    @RequestMapping("subscriber/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/subscriber";
    }
}
