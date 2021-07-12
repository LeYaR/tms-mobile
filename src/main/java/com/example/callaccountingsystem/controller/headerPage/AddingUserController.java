package com.example.callaccountingsystem.controller.headerPage;

import com.example.callaccountingsystem.controller.Pagination;
import com.example.callaccountingsystem.domain.dto.Address;
import com.example.callaccountingsystem.domain.dto.Subscriber;
import com.example.callaccountingsystem.service.AddressServiceInterface;
import com.example.callaccountingsystem.service.SubscriberServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/adding-user/")
public class AddingUserController {
    private final SubscriberServiceInterface service;

    public AddingUserController(SubscriberServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView viewAllSubscribers(Model model,
                                           @RequestParam("page") Optional<Integer> page,
                                           @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(40);

        final Page<Subscriber> subscriberPage = service.getAllSubscribers(currentPage, pageSize);
        new Pagination().getPagination(model, currentPage, subscriberPage);
        model.addAttribute("subscribers", subscriberPage);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addingUser");
        return modelAndView;
    }

}
