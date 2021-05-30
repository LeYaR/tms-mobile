package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CurrencyEntity;
import com.example.callaccountingsystem.domain.dto.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CurrencyMapper {

    CurrencyMapper CURRENCY_MAPPER = Mappers.getMapper(CurrencyMapper.class);

    Currency fromDbo(CurrencyEntity entity);

    CurrencyEntity toDbo(Currency dto);

    List<Currency> listFromDbo(List<CurrencyEntity> streets);
}
