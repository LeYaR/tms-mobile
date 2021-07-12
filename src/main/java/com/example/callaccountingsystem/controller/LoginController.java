package com.example.callaccountingsystem.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

        @GetMapping("/login")
        public ModelAndView greeting(Model model) {
            model.addAttribute("title", "Hello World");

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("authorization");
            return modelAndView;
        }
}
