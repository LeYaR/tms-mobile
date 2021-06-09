package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.TariffPlan;
import com.example.callaccountingsystem.service.TariffPlanServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class TariffPlanController {

    private final TariffPlanServiceInterface service;

    public TariffPlanController(TariffPlanServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/tariff-plan")
    public ModelAndView viewAllTariffPlans(Model model,
                                           @RequestParam("page") Optional<Integer> page,
                                           @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);
        final Page<TariffPlan> tariffPlanPage = service.getAllTariffPlans(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, tariffPlanPage);
        model.addAttribute("tariffPlans", tariffPlanPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tariffPlan");
        return modelAndView;
    }

    @RequestMapping("tariff-plan/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("tariffPlanEdit");
        mav.addObject("tariffPlan", service.get(id));
        return mav;
    }

    @RequestMapping(value = "tariff-plan/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("tariffPlan") TariffPlan tariffPlan) {
        service.save(tariffPlan);
        return "redirect:/tariff-plan";
    }

    @RequestMapping("tariff-plan/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        service.delete(id);
        return "redirect:/tariff-plan";
    }
}
