package com.example.callaccountingsystem.service;

import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface GenerationServiceInterface {

    @Async("generationThread")
    void generateMillion(List<Long> listPhoneNumber, List<Integer> listTowerName, List<Integer> listStatusName);

    void generate(int quantity, int fromMonth, int fromYear, int toMonth, int toYear, List<Long> listPhoneNumber,
                  List<Integer> listTowerName, List<Integer> listStatusName);
}

