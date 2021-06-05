package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Passport;
import com.example.callaccountingsystem.service.PassportServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/passport")
public class PassportController {

    private final PassportServiceInterface service;

    public PassportController(PassportServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllPassports(Model model, @RequestParam("page") Optional<Integer> page,
                                         @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        final Page<Passport> passportPage = service.getAllPassports(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, passportPage);
        model.addAttribute("passports", passportPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passport");
        return modelAndView;
    }
}
