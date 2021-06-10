package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CurrencyEntity;
import com.example.callaccountingsystem.domain.dto.Currency;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    Currency fromDbo(CurrencyEntity entity);

    CurrencyEntity toDbo(Currency dto);

    List<Currency> listFromDbo(List<CurrencyEntity> currencyEntities);
}
