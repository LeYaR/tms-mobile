package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Address;
import com.example.callaccountingsystem.domain.dto.Currency;
import com.example.callaccountingsystem.service.CurrencyServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView viewAllCurrencies(Model model,
                                          @RequestParam("page") Optional<Integer> page,
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

    @RequestMapping("currency/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("currencyEdit");
        mav.addObject("currency", service.get(id));
        return mav;
    }

    @RequestMapping(value = "currency/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("currency") Currency currency) {
        service.save(currency);
        return "redirect:/address";
    }

    @RequestMapping("currency/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/currency";
    }
}
