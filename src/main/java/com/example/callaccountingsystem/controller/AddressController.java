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

    @GetMapping("/address")
    public ModelAndView viewAllAddresses(Model model,
                                         @RequestParam("page") Optional<Integer> page,
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

    @RequestMapping("address/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("addressEdit");
        mav.addObject("address", service.get(id));
        return mav;
    }

    @RequestMapping(value = "address/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("address") Address address) {
        service.save(address);
        return "redirect:/address";
    }

    @RequestMapping("address/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/address";
    }
}


