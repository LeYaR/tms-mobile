package com.example.callaccountingsystem.domain.dbo;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@NoArgsConstructor
@Entity
@Table(name = "authorization")
public class AuthorizationEntity {
    @Id
    String login;
    String password;
}
