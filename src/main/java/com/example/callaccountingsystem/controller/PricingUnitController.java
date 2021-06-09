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
        final Page<PricingUnit> pricingUnits = service.getAllPricingUnits(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, pricingUnits);
        model.addAttribute("pricingUnits", pricingUnits);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pricingUnit");
        return modelAndView;
    }

    @RequestMapping("pricing-unit/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("pricingUnitEdit");
        mav.addObject("pricingUnit", service.get(id));
        return mav;
    }

    @RequestMapping(value = "pricing-unit/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("pricingUnit") PricingUnit pricingUnit) {
        service.save(pricingUnit);
        return "redirect:/pricing-unit";
    }

    @RequestMapping("pricing-unit/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        service.delete(id);
        return "redirect:/pricing-unit";
    }
}
