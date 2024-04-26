package com.Gomes.pizzaria.domain.dto;

import com.Gomes.pizzaria.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private UserType userType;
}
