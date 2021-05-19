package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.AddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface IAddressRepo extends CrudRepository<AddressEntity, Long> {
}
