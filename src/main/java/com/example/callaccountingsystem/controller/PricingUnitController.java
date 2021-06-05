package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.PricingUnit;
import com.example.callaccountingsystem.service.PricingUnitServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/pricing-unit")
public class PricingUnitController {

    private final PricingUnitServiceInterface service;

    public PricingUnitController(PricingUnitServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllPricingUnits(Model model, @RequestParam("page") Optional<Integer> page,
                                            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        final Page<PricingUnit> pricingUnits = service.getAllPricingUnits(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, pricingUnits);
        model.addAttribute("pricingUnits", pricingUnits);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pricingUnit");
        return modelAndView;
    }
}
