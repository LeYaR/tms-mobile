package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.MobileOperator;
import com.example.callaccountingsystem.service.MobileOperatorServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class MobileOperatorController {

    private final MobileOperatorServiceInterface service;

    public MobileOperatorController(MobileOperatorServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/mobile-operator")
    public ModelAndView viewAllMobileOperators(Model model,
                                               @RequestParam("page") Optional<Integer> page,
                                               @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);
        final Page<MobileOperator> mobileOperatorPage = service.getAllMobileOperators(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, mobileOperatorPage);
        model.addAttribute("mobileOperators", mobileOperatorPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mobileOperator");
        return modelAndView;
    }

    @GetMapping("/mobile-operator/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("mobileOperatorEditing");
        mav.addObject("mobileOperator", service.get(id));
        return mav;
    }

    @PostMapping("/mobile-operator/save")
    public ModelAndView save(@ModelAttribute("mobileOperator") MobileOperator mobileOperator) {
        service.save(mobileOperator);
        return new ModelAndView("redirect:/mobile-operator");
    }

}
