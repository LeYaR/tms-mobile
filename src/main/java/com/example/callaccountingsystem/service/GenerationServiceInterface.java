package com.example.callaccountingsystem.service;

public interface GenerationServiceInterface {

    //    @Async("taskExecutor")
    void generateMillion();

    //    @Async("taskExecutor")
    void generate(int quantity, int fromMonth, int fromYear, int toMonth, int toYear);
}
