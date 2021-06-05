package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Tower;
import com.example.callaccountingsystem.service.TowerServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/tower")
public class TowerController {

    private final TowerServiceInterface service;

    public TowerController(TowerServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllTowers(Model model, @RequestParam("page") Optional<Integer> page,
                                      @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        final Page<Tower> towerPage = service.getAllTowers(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, towerPage);
        model.addAttribute("towers", towerPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tower");
        return modelAndView;
    }
}
