package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.MobileOperator;
import com.example.callaccountingsystem.service.MobileOperatorServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/mobile-operator")
public class MobileOperatorController {

    private final MobileOperatorServiceInterface service;

    public MobileOperatorController(MobileOperatorServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllMobileOperators(Model model, @RequestParam("page") Optional<Integer> page,
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
}
