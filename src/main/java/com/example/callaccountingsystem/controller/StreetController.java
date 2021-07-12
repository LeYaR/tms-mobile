package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Street;
import com.example.callaccountingsystem.service.StreetServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class StreetController {

    private final StreetServiceInterface service;

    public StreetController(StreetServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/street")
    public ModelAndView viewAllStreets(Model model,
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
        final Page<Street> streetPage = service.getAllStreets(currentPage, pageSize);
        model.addAttribute("streets", streetPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("street");
        return modelAndView;
    }

    @GetMapping("/street/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("streetEditing");
        mav.addObject("street", service.get(id));
        return mav;
    }

    @PostMapping("/street/save")
    public ModelAndView save(@ModelAttribute("street") Street street) {
        service.save(street);
        return new ModelAndView("redirect:/street");
    }

}
