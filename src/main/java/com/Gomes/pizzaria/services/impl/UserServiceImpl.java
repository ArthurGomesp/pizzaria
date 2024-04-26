package com.Gomes.pizzaria.services.impl;

import com.Gomes.pizzaria.domain.dto.UserUpdateDTO;
import com.Gomes.pizzaria.domain.enums.StatusAccount;
import com.Gomes.pizzaria.domain.User;
import com.Gomes.pizzaria.domain.dto.UserCreateDTO;
import com.Gomes.pizzaria.domain.dto.UserInfoDTO;
import com.Gomes.pizzaria.exception.DisabledAccountException;
import com.Gomes.pizzaria.exception.ObjectNotFound;
import com.Gomes.pizzaria.repositories.UserRepository;
import com.Gomes.pizzaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(UserCreateDTO dto){
        User user = new User(dto);
        return userRepository.save(user);
    }

    @Override
    public UserInfoDTO findByID(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            if (!verifyStatusAccount(user)) {
                throw new DisabledAccountException("Esta conta foi desativada!");
            }

            return new UserInfoDTO( user.get().getName(), user.get().getEmail(),
                    user.get().getPhoneNumber(), user.get().getActiveAccount(), user.get().getUserType());
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
                throw new RuntimeException("Erro ao desabilitar esta conta.");
            }
        }else {
            throw new ObjectNotFound("Objeto não encontrado.");
        }

    }

    @Override
    public ResponseEntity update(Long id, UserUpdateDTO dto) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            User userUpdate = user.get();
            if (!verifyStatusAccount(user)) {
                throw new DisabledAccountException("Esta conta foi desativada!");
            }
            if (dto.getName() != null) {
                userUpdate.setName(dto.getName());
            }
            if (dto.getEmail() != null) {
                userUpdate.setEmail(dto.getEmail());
            }
            if (dto.getPhoneNumber() != null) {
                userUpdate.setPhoneNumber(dto.getPhoneNumber());
            }
            if (dto.getUserType() != null) {
                userUpdate.setUserType(dto.getUserType());
            }
            userRepository.save(userUpdate);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new UserInfoDTO(findByID(id)));

    }

    public Boolean verifyStatusAccount(Optional<User> user){
        return user.get().getActiveAccount().equals(StatusAccount.ACTIVE);
    }
}
