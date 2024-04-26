package com.Gomes.pizzaria.services.impl;

import com.Gomes.pizzaria.domain.User;
import com.Gomes.pizzaria.domain.dto.UserCreateDTO;
import com.Gomes.pizzaria.domain.dto.UserInfoDTO;
import com.Gomes.pizzaria.domain.enums.StatusAccount;
import com.Gomes.pizzaria.domain.enums.UserType;
import com.Gomes.pizzaria.exception.DisabledAccountException;
import com.Gomes.pizzaria.exception.ObjectNotFound;

import com.Gomes.pizzaria.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

class userServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create() {
        // Arrange
        UserCreateDTO dto = new UserCreateDTO("John Doe", "john.doe@example.com", "password123",
                "1234567890", UserType.CLIENT);

        User user = new User( );
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
        user.setPhoneNumber("1234567890");
        user.setUserType(UserType.CLIENT);
        when(userRepository.save(any())).thenReturn(user);

        // Act
        User result = userService.create(dto);

        // Assert
        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals("john.doe@example.com", result.getEmail());
        assertEquals("password123", result.getPassword());
        assertEquals("1234567890", result.getPhoneNumber());
        assertEquals(UserType.CLIENT, result.getUserType());
    }

    @Test
    void findByID() {
        Long id = 1L;
        User user = new User(id, "John Doe", "johndoe@example.com", "password", "1234567890");
        user.setActiveAccount(StatusAccount.ACTIVE);
        Optional<User> optionalUser = Optional.of(user);
        Mockito.when(userRepository.findById(id)).thenReturn(optionalUser);

        UserInfoDTO actual = userService.findByID(id);

        assertEquals(user.getName(), actual.getName());
        assertEquals(user.getEmail(), actual.getEmail());
        assertEquals(user.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(user.getActiveAccount(), actual.getActiveAccount());
        assertEquals(user.getUserType(), actual.getUserType());
    }

    @Test
    void findByID_with_UserNotFound() {
        assertThrows(ObjectNotFound.class, () ->{
            userService.findByID(1L);
        });
    }
    @Test
    void findByID_with_DisabledAccount() {
        User user = new User(1L, "John Doe", "johndoe@example.com", "password", "1234567890");
        user.setActiveAccount(StatusAccount.DISABLED);

        Optional<User> optionalUser = Optional.of(user);
        Mockito.when(userRepository.findById(1L)).thenReturn(optionalUser);
        assertThrows(DisabledAccountException.class, () ->{
            userService.findByID(1L);
        });
    }

    @Test
    void disableAccount() {
        // Arrange
        Long id = 1L;
        User user = new User(id, "John Doe", "johndoe@example.com", "password", "1234567890");
        user.setActiveAccount(StatusAccount.ACTIVE);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        // Act
        String result = userService.disableAccount(id);

        // Assert
        assertEquals("Esta conta foi desabilitada com sucesso!", result);
    }

    @Test
    void disableAccount_with_UserNotFound() {
        assertThrows(ObjectNotFound.class, () ->{
            userService.disableAccount(1L);
        });
    }



    @Test
    void verifyStatusAccount() {
        // Arrange
        User user = new User();
        user.setActiveAccount(StatusAccount.ACTIVE);
        Optional<User> optionalUser = Optional.of(user);

        // Act
        Boolean result = userService.verifyStatusAccount(optionalUser);

        // Assert
        assertTrue(result);
    }
}