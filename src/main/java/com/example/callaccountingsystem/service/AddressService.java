package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.AddressEntity;
import com.example.callaccountingsystem.domain.dto.Address;
import com.example.callaccountingsystem.domain.dto.City;
import com.example.callaccountingsystem.domain.dto.Country;
import com.example.callaccountingsystem.domain.dto.Street;
import com.example.callaccountingsystem.domain.mapping.AddressMapper;
import com.example.callaccountingsystem.exception.FieldAlreadyExistException;
import com.example.callaccountingsystem.repository.AddressRepository;
import com.example.callaccountingsystem.repository.StreetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements AddressServiceInterface {

    private final AddressRepository repository;
    private final StreetRepository streetRepository;
    private final AddressMapper mapper;

    public AddressService(AddressRepository repository, StreetRepository streetRepository, AddressMapper mapper) {
        this.repository = repository;
        this.streetRepository = streetRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<Address> getAllAddress(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<AddressEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public int getQuantityPages(int pageSize) {
        return repository.findAll().size() / pageSize + 1;
    }

    public Address get(Long id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(Address address) {
        final Street street = address.getStreet();
        final City city = address.getStreet().getCity();
        final Country country = address.getStreet().getCity().getCountry();
        if (repository.findFirstByFlatAndHouseAndStreet_StreetAndStreet_City_CityAndStreet_City_Country_Country(
                address.getFlat().trim(),
                address.getHouse().trim(),
                street.getStreet().trim(),
                city.getCity().trim(),
                country.getCountry().trim())
                .isPresent()) {
            throw new FieldAlreadyExistException("The address: " + country.getCountry() + ", "
                    + city.getCity() + ", " + street.getStreet() + ", " + address.getHouse()
                    + "-" + address.getFlat() + " - already exists!");
        }
        final AddressEntity addressEntity = mapper.toDbo(address);
        streetRepository.findFirstByStreetAndCity_CityAndCity_Country_Country(street.getStreet().trim(),
                city.getCity().trim(),
                country.getCountry().trim())
                .ifPresent(addressEntity::setStreet);
        repository.save(addressEntity);
    }

}
