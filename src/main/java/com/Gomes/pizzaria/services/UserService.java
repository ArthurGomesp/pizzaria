package com.Gomes.pizzaria.services;

import com.Gomes.pizzaria.domain.User;
import com.Gomes.pizzaria.domain.dto.UserCreateDTO;
import com.Gomes.pizzaria.domain.dto.UserInfoDTO;
import com.Gomes.pizzaria.domain.dto.UserUpdateDTO;
import org.springframework.http.ResponseEntity;


public interface UserService {

    User create(UserCreateDTO dto);

    UserInfoDTO findByID(Long id);
    String disableAccount(Long id);
    ResponseEntity update(Long id, UserUpdateDTO dto);

}


