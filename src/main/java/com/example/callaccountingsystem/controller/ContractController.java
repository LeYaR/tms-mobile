package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Contract;
import com.example.callaccountingsystem.service.ContractServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/contract")
public class ContractController {

    private final ContractServiceInterface service;

    public ContractController(ContractServiceInterface service) {
        this.service = service;
    }

    @GetMapping
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


    @RequestMapping("contract/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("contractEdit");
        mav.addObject("contract", service.get(id));
        return mav;
    }

    @RequestMapping(value = "contract/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("contract") Contract contract) {
        service.save(contract);
        return "redirect:/contract";
    }

    @RequestMapping("contract/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/contract";
    }
}
