package com.Gomes.pizzaria.services.impl;

import com.Gomes.pizzaria.domain.User;
import com.Gomes.pizzaria.domain.dto.UserCreateDTO;
import com.Gomes.pizzaria.domain.dto.UserInfoDTO;
import com.Gomes.pizzaria.repositories.userRepository;
import com.Gomes.pizzaria.services.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private userRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @Override

    public User create(UserCreateDTO dto){
        return userRepository.save(mapper.map(dto, User.class));
    }
    @Override

    public UserInfoDTO findByID(Long id){
        Optional<User> user = userRepository.findById(id);
        return mapper.map(user, UserInfoDTO.class);
    }

    public UserInfoDTO findByID(Long id){
        Optional<User> user = userRepository.findById(id);
        return mapper.map(user, UserInfoDTO.class);
    }
}
