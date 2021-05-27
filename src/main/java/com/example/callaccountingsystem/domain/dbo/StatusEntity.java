package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "status")
public class StatusEntity {
    @Id
    private Integer code;
    private String status;

    @OneToMany(mappedBy = "statusEntity")
    private List<CallEntity> calls;
}
