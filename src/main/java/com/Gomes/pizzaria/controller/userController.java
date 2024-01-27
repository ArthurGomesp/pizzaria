package com.Gomes.pizzaria.controller;

import com.Gomes.pizzaria.domain.User;
import com.Gomes.pizzaria.domain.dto.UserCreateDTO;
import com.Gomes.pizzaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserCreateDTO dto){
        User user = userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable @RequestBody Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findByID(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @RequestBody Long id){
        userService.disableAccount(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario desativado com sucesso!");
    }
}
