package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Currency;
import com.example.callaccountingsystem.service.CurrencyServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyServiceInterface service;

    public CurrencyController(CurrencyServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllCurrencies(Model model, @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        final Page<Currency> currencyPage = service.getAllCurrencies(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, currencyPage);
        model.addAttribute("currencies", currencyPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("currency");
        return modelAndView;
    }
}
