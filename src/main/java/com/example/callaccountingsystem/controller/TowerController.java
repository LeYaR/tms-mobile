package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Tower;
import com.example.callaccountingsystem.service.TowerServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class TowerController {

    private final TowerServiceInterface service;

    public TowerController(TowerServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/tower")
    public ModelAndView viewAllTowers(Model model,
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
        final Page<Tower> towerPage = service.getAllTowers(currentPage, pageSize);
        model.addAttribute("towers", towerPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tower");
        return modelAndView;
    }

    @GetMapping("/tower/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("towerEditing");
        mav.addObject("tower", service.get(id));
        return mav;
    }

    @PostMapping("/tower/save")
    public ModelAndView save(@ModelAttribute("tower") Tower tower) {
        service.save(tower);
        return new ModelAndView("redirect:/tower");
    }

}
