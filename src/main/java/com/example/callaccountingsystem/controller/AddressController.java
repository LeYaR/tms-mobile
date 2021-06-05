package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Address;
import com.example.callaccountingsystem.service.AddressServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressServiceInterface service;

    public AddressController(AddressServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllAddresses(Model model, @RequestParam("page") Optional<Integer> page,
                                         @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        final Page<Address> addressPage = service.getAllAddress(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, addressPage);
        model.addAttribute("addresses", addressPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("address");
        return modelAndView;
    }

}


