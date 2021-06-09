package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.domain.dto.Call;
import com.example.callaccountingsystem.service.CallServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
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

        final Page<Call> callPage = service.getAllCalls(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, callPage);
        model.addAttribute("calls", callPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("call");
        return modelAndView;
    }


    @PostMapping(value = "/filter")
    public ModelAndView filter(Model model,
                                    @RequestParam("page") Optional<Integer> page,
                                    @RequestParam("size") Optional<Integer> size,
                                    @RequestParam(name = "date1", required=false) LocalDate date1,
                                    @RequestParam(name = "date2", required=false) LocalDate date2,
                                    @RequestParam(name = "incoming", required=false) Long incoming,
                                    @RequestParam(name = "outgoing", required=false) Long outgoing,
                                    @RequestParam(name = "tower", required=false) String tower,
                                    @RequestParam(name = "status", required=false) String status) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(50);

        final Page<Call> callPage = service.getAllFilterCalls(currentPage, pageSize, date1, date2, incoming,
                outgoing, tower, status);
        new Pagination().getPagination(model, currentPage, callPage);

        model.addAttribute("calls", callPage);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("call");
        return modelAndView;
    }


}
