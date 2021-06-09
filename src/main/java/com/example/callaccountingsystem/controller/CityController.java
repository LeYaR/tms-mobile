package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.City;
import com.example.callaccountingsystem.service.CityServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView viewAllCities(Model model,
                                      @RequestParam("page") Optional<Integer> page,
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

    @RequestMapping("city/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("cityEdit");
        mav.addObject("city", service.get(id));
        return mav;
    }

    @RequestMapping(value = "city/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("city") City city) {
        service.save(city);
        return "redirect:/city";
    }

    @RequestMapping("city/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/city";
    }
}
