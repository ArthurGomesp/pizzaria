package com.Gomes.pizzaria.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UserCreateDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
