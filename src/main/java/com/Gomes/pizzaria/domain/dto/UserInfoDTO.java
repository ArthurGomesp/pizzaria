package com.Gomes.pizzaria.domain.dto;

import com.Gomes.pizzaria.domain.StatusAccount;
import com.Gomes.pizzaria.domain.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
