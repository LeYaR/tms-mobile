package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Tower;
import org.springframework.data.domain.Page;

public interface TowerServiceInterface {

    Page<Tower> getAllTowers(int currentPage, int pageSize);

}
