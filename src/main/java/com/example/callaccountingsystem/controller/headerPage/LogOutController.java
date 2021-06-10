package com.example.callaccountingsystem.controller.headerPage;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/log-out")
public class LogOutController {

    @GetMapping
    public ModelAndView logOutGet(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tables");
        return modelAndView;
    }

}
