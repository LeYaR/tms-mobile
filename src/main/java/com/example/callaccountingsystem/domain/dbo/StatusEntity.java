package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class StatusEntity {
    @Id
    private Integer code;
    private String status;

    @OneToMany(mappedBy = "statusEntity")
    private List<CallEntity> callEntities;
}
