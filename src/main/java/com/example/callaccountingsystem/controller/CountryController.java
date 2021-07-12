package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Country;
import com.example.callaccountingsystem.service.CountryServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class CountryController {

    private final CountryServiceInterface service;

    public CountryController(CountryServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/country")
    public ModelAndView viewAllCountries(Model model,
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
        final Page<Country> countryPage = service.getAllCountries(currentPage, pageSize);
        model.addAttribute("countries", countryPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("country");
        return modelAndView;
    }

    @GetMapping("/country/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("countryEditing");
        mav.addObject("country", service.get(id));
        return mav;
    }

    @PostMapping("country/save")
    public ModelAndView save(@ModelAttribute("country") Country country) {
        service.save(country);
        return new ModelAndView("redirect:/country");
    }

    @GetMapping("/country/new")
    ModelAndView create(Model model){
        Country country = new Country();
        model.addAttribute("country", country);
        ModelAndView mav = new ModelAndView("countryNew");
        return mav;
    }

}
