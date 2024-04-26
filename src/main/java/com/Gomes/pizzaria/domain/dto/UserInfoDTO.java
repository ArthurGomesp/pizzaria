package com.Gomes.pizzaria.domain.dto;


import com.Gomes.pizzaria.domain.enums.StatusAccount;
import com.Gomes.pizzaria.domain.enums.UserType;
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


    public UserInfoDTO(UserInfoDTO byID) {
        this(byID.getName(), byID.getEmail(), byID.getPhoneNumber(), byID.getActiveAccount(), byID.getUserType());
    }
}
