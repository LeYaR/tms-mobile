package com.example.callaccountingsystem.controller.headerPage;

import com.example.callaccountingsystem.service.SubscriberServiceInterface;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserEditingController {
    private final SubscriberServiceInterface service;

    public UserEditingController(SubscriberServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/user-editing")
    public ModelAndView userEditingGet(@RequestParam(name = "number") Long number, Model model) {
        ModelAndView mav = new ModelAndView("userEditing");
        mav.addObject("subscriber", service.get(number));
        return mav;
    }
}
