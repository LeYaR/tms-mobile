package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Call;
import com.example.callaccountingsystem.service.CallServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
public class CallController {

    private final CallServiceInterface service;

    public CallController(CallServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/call")
    public ModelAndView viewAllCalls(Model model,
                                     @RequestParam("page") Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(50);
        int quantityPage = service.getQuantityPages(pageSize);
        if(currentPage > quantityPage || currentPage < 1){
            return new ModelAndView("redirect:/tables");
        }
        model.addAttribute("quantityPage", quantityPage);
        model.addAttribute("numberPage", currentPage);
        final Page<Call> callPage = service.getAllCalls(currentPage, pageSize);
        model.addAttribute("calls", callPage);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("formatter", formatter);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("call");
        return modelAndView;
    }

}
