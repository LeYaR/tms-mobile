package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CurrencyEntity;
import com.example.callaccountingsystem.domain.dto.Currency;
import com.example.callaccountingsystem.domain.mapping.CurrencyMapper;
import com.example.callaccountingsystem.repository.CurrencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService implements CurrencyServiceInterface {

    private final CurrencyRepository repository;

    public CurrencyService(CurrencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Currency> getAllCurrencies() {
        final List<CurrencyEntity> list = repository.findAll();
        return CurrencyMapper.CURRENCY_MAPPER.listFromDbo(list);
    }
}
