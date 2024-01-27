package com.Gomes.pizzaria.domain.dto;


import com.Gomes.pizzaria.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UserCreateDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private UserType userType;
}
