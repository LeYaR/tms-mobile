package com.example.callaccountingsystem.service;

import org.springframework.scheduling.annotation.Async;

public interface GenerationServiceInterface {

    @Async("generationThread")
    void generateMillion();

    void generate(int quantity, int fromMonth, int fromYear, int toMonth, int toYear);
}

