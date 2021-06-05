package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Street;
import com.example.callaccountingsystem.service.StreetServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/street")
public class StreetController {

    private final StreetServiceInterface service;

    public StreetController(StreetServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllStreets(Model model, @RequestParam("page") Optional<Integer> page,
                                       @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        final Page<Street> streetPage = service.getAllStreets(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, streetPage);
        model.addAttribute("streets", streetPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("street");
        return modelAndView;
    }
}
