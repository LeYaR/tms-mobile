package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Tower;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TowerServiceInterface {

    Page<Tower> getAllTowers(int currentPage, int pageSize);

    List<Integer> getAllListTowerId();
}
