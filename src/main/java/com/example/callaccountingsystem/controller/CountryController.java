package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Country;
import com.example.callaccountingsystem.service.CountryServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryServiceInterface service;

    public CountryController(CountryServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllCountries(Model model, @RequestParam("page") Optional<Integer> page,
                                         @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        final Page<Country> countryPage = service.getAllCountries(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, countryPage);
        model.addAttribute("countries", countryPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("country");
        return modelAndView;
    }
}
