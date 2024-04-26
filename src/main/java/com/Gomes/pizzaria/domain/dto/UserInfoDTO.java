package com.Gomes.pizzaria.domain.dto;

import com.Gomes.pizzaria.domain.User;
import com.Gomes.pizzaria.domain.enums.StatusAccount;
import com.Gomes.pizzaria.domain.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private StatusAccount activeAccount;
    private UserType userType;


}
