package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Call;
import com.example.callaccountingsystem.service.CallServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/call")
public class CallController {

    private final CallServiceInterface service;

    public CallController(CallServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllCalls(Model model, @RequestParam("page") Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(50);

        final Page<Call> callPage = service.getAllCalls(currentPage, pageSize);

        new Pagination().getPagination(model, currentPage, callPage);

        model.addAttribute("calls", callPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("call");
        return modelAndView;
    }
}
