package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.PricingUnit;
import com.example.callaccountingsystem.service.PricingUnitServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class PricingUnitController {

    private final PricingUnitServiceInterface service;

    public PricingUnitController(PricingUnitServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/pricing-unit")
    public ModelAndView viewAllPricingUnits(Model model,
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
        final Page<PricingUnit> pricingUnits = service.getAllPricingUnits(currentPage, pageSize);
        model.addAttribute("pricingUnits", pricingUnits);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pricingUnit");
        return modelAndView;
    }

    @GetMapping("/pricing-unit/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("pricingUnitEditing");
        mav.addObject("pricingUnit", service.get(id));
        return mav;
    }

    @PostMapping("/pricing-unit/save")
    public ModelAndView save(@ModelAttribute("pricingUnit") PricingUnit pricingUnit) {
        service.save(pricingUnit);
        return new ModelAndView("redirect:/pricing-unit");
    }

}
