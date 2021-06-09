package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Country;
import com.example.callaccountingsystem.service.CountryServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView viewAllCountries(Model model,
                                         @RequestParam("page") Optional<Integer> page,
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

    @RequestMapping("country/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("countryEdit");
        mav.addObject("country", service.get(id));
        return mav;
    }

    @RequestMapping(value = "country/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("country") Country country) {
        service.save(country);
        return "redirect:/country";
    }

    @RequestMapping("country/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/country";
    }
}
