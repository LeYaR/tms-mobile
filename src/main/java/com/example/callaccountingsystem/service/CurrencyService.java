package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CurrencyEntity;
import com.example.callaccountingsystem.domain.dto.Currency;
import com.example.callaccountingsystem.domain.mapping.CurrencyMapper;
import com.example.callaccountingsystem.exception.FieldAlreadyExistException;
import com.example.callaccountingsystem.repository.CurrencyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements CurrencyServiceInterface {

    private final CurrencyRepository repository;
    private final CurrencyMapper mapper;

    public CurrencyService(CurrencyRepository repository, CurrencyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Currency> getAllCurrencies(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<CurrencyEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public int getQuantityPages(int pageSize) {
        return repository.findAll().size() / pageSize + 1;
    }

    @Override
    public Currency get(Long id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(Currency currency) {
        if (repository.findFirstByCodeAndAndNumericalCodeAndName(currency.getCode().trim(),
                currency.getNumericalCode(), currency.getName().trim()).isPresent()) {
            throw new FieldAlreadyExistException("Currency \"" + currency.getName() + "\" already exists!");
        }
        repository.save(mapper.toDbo(currency));
    }

}
