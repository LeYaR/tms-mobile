package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.ClientType;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import java.util.List;

public interface IClientTypeService {

    List<ClientType> getAllClients();

}
