package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Address;
import com.example.callaccountingsystem.service.AddressServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class AddressController {

    private final AddressServiceInterface service;

    public AddressController(AddressServiceInterface service) {
        this.service = service;
    }

    @GetMapping(value = "/address")
    public ModelAndView viewAllAddresses(Model model,
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
        final Page<Address> addressPage = service.getAllAddress(currentPage, pageSize);
        model.addAttribute("addresses", addressPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("address");
        return modelAndView;
    }

    @GetMapping("/address/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("addressEditing");
        mav.addObject("address", service.get(id));
        return mav;
    }

    @PostMapping("/address/save")
    public ModelAndView save(@ModelAttribute("address") Address address) {
        if (address != null) {
            service.save(address);
        }
        return new ModelAndView("redirect:/address");
    }

}


