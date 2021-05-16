package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class ClientTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;

    @OneToMany(mappedBy = "clientTypeEntity")
    private List<ContractEntity> contractEntities;
}
