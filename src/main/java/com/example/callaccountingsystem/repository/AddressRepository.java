package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.AddressEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    Page<AddressEntity> findAll(Pageable pageable);

    Optional<AddressEntity> findFirstByFlatAndHouseAndStreet_StreetAndStreet_City_CityAndStreet_City_Country_Country
            (String flat, String house, String street, String city, String country);

}
