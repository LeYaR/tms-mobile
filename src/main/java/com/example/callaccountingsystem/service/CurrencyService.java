package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CurrencyEntity;
import com.example.callaccountingsystem.domain.dto.Currency;
import com.example.callaccountingsystem.domain.mapping.CurrencyMapper;
import com.example.callaccountingsystem.repository.ICurrencyRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyService implements ICurrencyService {

    private final ICurrencyRepo repository;

    public CurrencyService(ICurrencyRepo repository){this.repository=repository;}

    @Override
    public List<Currency> getAllCurrencies(){
        final List<CurrencyEntity> list = repository.findAll();
        List<Currency> currencies = new ArrayList<>();
        list.forEach((currencyEntity -> currencies.add(CurrencyMapper.CURRENCY_MAPPER.fromDbo(currencyEntity))));
        return currencies;
    }
}
