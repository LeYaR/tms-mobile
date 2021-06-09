package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.PricingUnit;
import com.example.callaccountingsystem.domain.dto.Status;
import com.example.callaccountingsystem.service.StatusServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusServiceInterface service;

    public StatusController(StatusServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllStatuses(Model model,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);

        final Page<Status> statusPage = service.getAllStatuses(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, statusPage);
        model.addAttribute("statuses", statusPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("status");
        return modelAndView;
    }

    @RequestMapping("status/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("statusEdit");
        mav.addObject("status", service.get(id));
        return mav;
    }

    @RequestMapping(value = "status/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("status") Status status) {
        service.save(status);
        return "redirect:/status";
    }

    @RequestMapping("status/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        service.delete(id);
        return "redirect:/status";
    }
}
