package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Passport;
import com.example.callaccountingsystem.service.PassportServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class PassportController {

    private final PassportServiceInterface service;

    public PassportController(PassportServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/passport")
    public ModelAndView viewAllPassports(Model model,
                                         @RequestParam("page") Optional<Integer> page,
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

    @GetMapping("/passport/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") String id) {
        ModelAndView mav = new ModelAndView("passportEditing");
        mav.addObject("passport", service.get(id));
        return mav;
    }

    @PostMapping("/passport/save")
    public ModelAndView save(@ModelAttribute("passport") Passport passport) {
        service.save(passport);
        return new ModelAndView("redirect:/passport");
    }

}
