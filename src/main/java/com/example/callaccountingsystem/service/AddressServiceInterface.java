package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Address;
import org.springframework.data.domain.Page;

public interface AddressServiceInterface {

    Page<Address> getAllAddress(int currentPage, int pageSize);

}
