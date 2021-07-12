package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StreetRepository extends JpaRepository<StreetEntity, Long> {

    Page<StreetEntity> findAll(Pageable pageable);

    Optional<StreetEntity> findFirstByStreetAndCity_CityAndCity_Country_Country(String street,
                                                                                String city,
                                                                                String country);
}
