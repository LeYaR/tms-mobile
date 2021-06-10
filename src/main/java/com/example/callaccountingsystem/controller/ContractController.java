package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Contract;
import com.example.callaccountingsystem.service.ContractServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
public class ContractController {

    private final ContractServiceInterface service;

    public ContractController(ContractServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/contract")
    public ModelAndView viewAllContracts(Model model,
                                         @RequestParam("page") Optional<Integer> page,
                                         @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(20);
        final Page<Contract> contractPage = service.getAllContracts(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, contractPage);
        model.addAttribute("contracts", contractPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contract");
        return modelAndView;
    }


    @GetMapping("contract/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("contractEditing");
        mav.addObject("contract", service.get(id));
        return mav;
    }

    @PostMapping("contract/save")
    public String save(@ModelAttribute("contract") Contract contract) {
        service.save(contract);
        return "redirect:/contract";
    }

}
