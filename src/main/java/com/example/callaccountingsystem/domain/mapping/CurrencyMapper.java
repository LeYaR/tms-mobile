package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CurrencyEntity;
import com.example.callaccountingsystem.domain.dto.Currency;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper {

    public Currency fromDbo(CurrencyEntity entity) {
        final Currency dto = new Currency();
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setNumericalCode(entity.getNumericalCode());
        return dto;
    }

    public CurrencyEntity toDbo(Currency dto) {
        final CurrencyEntity entity = new CurrencyEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setNumericalCode(dto.getNumericalCode());
        return entity;
    }
}
