package com.Gomes.pizzaria.services.impl;

import com.Gomes.pizzaria.domain.enums.StatusAccount;
import com.Gomes.pizzaria.domain.User;
import com.Gomes.pizzaria.domain.dto.UserCreateDTO;
import com.Gomes.pizzaria.domain.dto.UserInfoDTO;
import com.Gomes.pizzaria.exception.DisabledAccountException;
import com.Gomes.pizzaria.exception.ObjectNotFound;
import com.Gomes.pizzaria.repositories.UserRepository;
import com.Gomes.pizzaria.services.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @Override

    public User create(UserCreateDTO dto){
        return userRepository.save(mapper.map(dto, User.class));
    }
    @Override

    public UserInfoDTO findByID(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            if (!verifyStatusAccount(user)) {
                throw new DisabledAccountException("Esta conta foi desativada!");
            }

            return mapper.map(user, UserInfoDTO.class);
        } else {
            throw new ObjectNotFound("Objeto não encontrado.");
        }
    }

    public String disableAccount(Long id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setActiveAccount(StatusAccount.DISABLED);
            userRepository.save(user);

            if (userRepository.findById(user.getId()).get().getActiveAccount().equals(StatusAccount.DISABLED)) {
                return "Esta conta foi desabilitada com sucesso!";
            } else {
                return " ";
            }
        }else {
            throw new ObjectNotFound("Objeto não encontrado.");
        }

    }

    public Boolean verifyStatusAccount(Optional<User> user){
        if (user.get().getActiveAccount().equals(StatusAccount.ACTIVE)) return true;
        return false;
    }
}
