package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.City;
import com.example.callaccountingsystem.service.CityServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {

    private final CityServiceInterface service;

    public CityController(CityServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllCities(Model model, @RequestParam("page") Optional<Integer> page,
                                      @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        final Page<City> cityPage = service.getAllCity(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, cityPage);
        model.addAttribute("cities", cityPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("city");
        return modelAndView;
    }
}
