package com.example.callaccountingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

        @GetMapping("/")
        public String greeting(Model model) {
            model.addAttribute("title", "Hello World");
            return "login";
        }
}
