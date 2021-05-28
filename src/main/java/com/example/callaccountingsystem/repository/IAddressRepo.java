package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<AddressEntity, Long> {
}
