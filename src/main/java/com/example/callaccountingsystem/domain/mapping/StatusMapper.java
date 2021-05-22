package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.StatusEntity;
import com.example.callaccountingsystem.domain.dto.Status;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper {

    public Status fromDbo(StatusEntity entity) {
        final Status dto = new Status();
        dto.setStatus(entity.getStatus());
        entity.getCallEntities().forEach(call -> dto.getCallList().add(new CallMapper().fromDbo(call)));
        return dto;
    }

    public StatusEntity toDbo(Status dto) {
        final StatusEntity entity = new StatusEntity();
        entity.setStatus(dto.getStatus());
        dto.getCallList().forEach(call -> entity.getCallEntities().add(new CallMapper().toDbo(call)));
        return entity;
    }
}
