package com.example.callaccountingsystem.controller;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pagination<T> {

    public Model getPagination(Model model, int currentPage, Page<T> page) {
        int totalPages = page.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        return model;
    }

}
