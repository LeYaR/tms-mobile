package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.exception.IllegalPeriodForGeneration;
import com.example.callaccountingsystem.service.CallServiceInterface;
import com.example.callaccountingsystem.service.GenerationServiceInterface;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GenerationController {

    private final GenerationServiceInterface generationServiceInterface;
    private final CallServiceInterface callServiceInterface;

    public GenerationController(CallServiceInterface callServiceInterface,
                                GenerationServiceInterface generationServiceInterface) {
        this.callServiceInterface = callServiceInterface;
        this.generationServiceInterface = generationServiceInterface;
    }

    @GetMapping("/generation")
    public ModelAndView showForm(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("generation");
        return modelAndView;
    }

    @PostMapping("/generation-million")
    public ModelAndView generate() {
        generationServiceInterface.generateMillion();
        generationServiceInterface.generateMillion();
        generationServiceInterface.generateMillion();
        generationServiceInterface.generateMillion();
        generationServiceInterface.generateMillion();
        generationServiceInterface.generateMillion();
        generationServiceInterface.generateMillion();
        generationServiceInterface.generateMillion();
        return new ModelAndView("redirect:/generation");
    }

    @PostMapping("/generation-facts")
    public ModelAndView generateFacts(@RequestParam(name = "quantity") int quantity, @RequestParam(name = "fromMonth")
            int fromMonth, @RequestParam(name = "fromYear") int fromYear, @RequestParam(name = "toMonth") int toMonth,
                                      @RequestParam(name = "toYear") int toYear) {
        if (fromYear>toYear || (fromYear==toYear && fromMonth>toMonth)){
            throw new IllegalPeriodForGeneration("Invalid period.");
        }
        generationServiceInterface.generate(quantity, fromMonth, fromYear, toMonth, toYear);
        return new ModelAndView("redirect:/call");
    }
}
