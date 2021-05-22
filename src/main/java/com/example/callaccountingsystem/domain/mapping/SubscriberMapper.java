package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import com.example.callaccountingsystem.domain.dto.Subscriber;
import org.springframework.stereotype.Component;

@Component
public class SubscriberMapper {

    public Subscriber fromDbo(SubscriberEntity entity) {
        final Subscriber dto = new Subscriber();
        dto.setAddress(new AddressMapper().fromDbo(entity.getAddressEntity()));
        dto.setBirthday(entity.getBirthday());
        dto.setContract(new ContractMapper().fromDbo(entity.getContractEntity()));
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setMiddleName(entity.getMiddleName());
        dto.setMobileOperator(new MobileOperatorMapper().fromDbo(entity.getMobileOperatorEntity()));
        dto.setPassport(new PassportEntityMapper().fromDbo(entity.getPassportEntity()));
        dto.setPhoneNumber(entity.getPhoneNumber());
        entity.getOutgoingCallEntity().forEach(call -> dto.getOutgoingCallList().add(new CallMapper().fromDbo(call)));
        entity.getIncomingCallEntity().forEach(call -> dto.getIncomingCallList().add(new CallMapper().fromDbo(call)));
        return dto;
    }

    public SubscriberEntity toDbo(Subscriber dto) {
        final SubscriberEntity entity = new SubscriberEntity();
        entity.setAddressEntity(new AddressMapper().toDbo(dto.getAddress()));
        entity.setBirthday(dto.getBirthday());
        entity.setContractEntity(new ContractMapper().toDbo(dto.getContract()));
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setMiddleName(dto.getMiddleName());
        entity.setMobileOperatorEntity(new MobileOperatorMapper().toDbo(dto.getMobileOperator()));
        entity.setPassportEntity(new PassportEntityMapper().toDbo(dto.getPassport()));
        entity.setPhoneNumber(dto.getPhoneNumber());
        dto.getOutgoingCallList().forEach(call -> entity.getOutgoingCallEntity().add(new CallMapper().toDbo(call)));
        dto.getIncomingCallList().forEach(call -> entity.getIncomingCallEntity().add(new CallMapper().toDbo(call)));
        return entity;
    }
}
