package com.example.callaccountingsystem.controller;

import com.example.callaccountingsystem.exception.IllegalPeriodForGeneration;
import com.example.callaccountingsystem.service.GenerationServiceInterface;
import com.example.callaccountingsystem.service.StatusServiceInterface;
import com.example.callaccountingsystem.service.SubscriberServiceInterface;
import com.example.callaccountingsystem.service.TowerServiceInterface;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class GenerationController {

    private final GenerationServiceInterface generationServiceInterface;
    private final SubscriberServiceInterface subscriberServiceInterface;
    private final TowerServiceInterface towerServiceInterface;
    private final StatusServiceInterface statusServiceInterface;

    public GenerationController(GenerationServiceInterface generationServiceInterface,
                                SubscriberServiceInterface subscriberServiceInterface,
                                TowerServiceInterface towerServiceInterface,
                                StatusServiceInterface statusServiceInterface) {
        this.generationServiceInterface = generationServiceInterface;
        this.subscriberServiceInterface = subscriberServiceInterface;
        this.towerServiceInterface = towerServiceInterface;
        this.statusServiceInterface = statusServiceInterface;
    }

    @GetMapping("/generation")
    public ModelAndView showForm(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("generation");
        return modelAndView;
    }

    @PostMapping("/generation-million")
    public ModelAndView generate() {
        final List<Long> listPhoneNumber = subscriberServiceInterface.getAllPhoneNumbers();
        final List<Integer> listTowerName = towerServiceInterface.getAllListTowerId();
        final List<Integer> listStatusName = statusServiceInterface.getAllListStatusCode();
        generationServiceInterface.generateMillion(listPhoneNumber, listTowerName, listStatusName);
        generationServiceInterface.generateMillion(listPhoneNumber, listTowerName, listStatusName);
        generationServiceInterface.generateMillion(listPhoneNumber, listTowerName, listStatusName);
        generationServiceInterface.generateMillion(listPhoneNumber, listTowerName, listStatusName);
        generationServiceInterface.generateMillion(listPhoneNumber, listTowerName, listStatusName);
        generationServiceInterface.generateMillion(listPhoneNumber, listTowerName, listStatusName);
        generationServiceInterface.generateMillion(listPhoneNumber, listTowerName, listStatusName);
        generationServiceInterface.generateMillion(listPhoneNumber, listTowerName, listStatusName);
        return new ModelAndView("redirect:/generation");
    }

    @PostMapping("/generation-facts")
    public ModelAndView generateFacts(@RequestParam(name = "quantity") int quantity,
                                      @RequestParam(name = "fromMonth") int fromMonth,
                                      @RequestParam(name = "fromYear") int fromYear,
                                      @RequestParam(name = "toMonth") int toMonth,
                                      @RequestParam(name = "toYear") int toYear) {
        if (fromYear > toYear || (fromYear == toYear && fromMonth > toMonth)) {
            throw new IllegalPeriodForGeneration("Invalid period.");
        }
        final List<Long> listPhoneNumber = subscriberServiceInterface.getAllPhoneNumbers();
        final List<Integer> listTowerName = towerServiceInterface.getAllListTowerId();
        final List<Integer> listStatusName = statusServiceInterface.getAllListStatusCode();
        generationServiceInterface.generate(quantity, fromMonth, fromYear, toMonth, toYear, listPhoneNumber, listTowerName, listStatusName);
        return new ModelAndView("redirect:/call");
    }
}
