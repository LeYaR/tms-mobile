package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Currency;
import org.springframework.data.domain.Page;

public interface CurrencyServiceInterface {

    Page<Currency> getAllCurrencies(int currentPage, int pageSize);

    Currency get(Long id);

    void save(Currency currency);

}
