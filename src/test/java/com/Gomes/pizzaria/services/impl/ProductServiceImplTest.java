package com.Gomes.pizzaria.services.impl;

import com.Gomes.pizzaria.domain.Product;
import com.Gomes.pizzaria.domain.User;
import com.Gomes.pizzaria.domain.dto.ProductCreateDTO;
import com.Gomes.pizzaria.domain.dto.ProductInfoDTO;
import com.Gomes.pizzaria.domain.dto.UserInfoDTO;
import com.Gomes.pizzaria.domain.enums.ProductType;
import com.Gomes.pizzaria.domain.enums.StatusAccount;
import com.Gomes.pizzaria.domain.enums.UserType;
import com.Gomes.pizzaria.exception.ObjectNotFound;
import com.Gomes.pizzaria.exception.UnauthorizedProductCreationException;
import com.Gomes.pizzaria.repositories.ProductRepository;
import com.Gomes.pizzaria.services.UserService;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl service;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void create_is_Success() {
        // Arrange
        ProductCreateDTO dto = new ProductCreateDTO("Pizza", "Delicious pizza", ProductType.PIZZA, BigDecimal.valueOf(10.0));
        Long id = 1L;
        when(productRepository.save(any())).thenReturn(new Product(dto));

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserType(UserType.EMPLOYEE);
        when(userService.findByID(any())).thenReturn(userInfoDTO);
        // Act
        var result = service.create(dto, id);

        // Assert
        assertNotNull(result);
        assertEquals(dto.getProductName(), result.getProductName());
        assertEquals(dto.getDescription(), result.getDescription());
        assertEquals(dto.getProductType(), result.getProductType());
        assertEquals(dto.getUnitaryValue(), result.getUnitaryValue());
    }

    @Test
    void create_is_Unauthorized() {
        // Arrange
        ProductCreateDTO dto = new ProductCreateDTO("Pizza", "Delicious pizza", ProductType.PIZZA, BigDecimal.valueOf(10.0));
        Long id = 1L;
        when(productRepository.save(any())).thenReturn(new Product(dto));

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserType(UserType.CLIENT);
        when(userService.findByID(any())).thenReturn(userInfoDTO);

        assertThrows(UnauthorizedProductCreationException.class, () ->{
            service.create(dto, id);
        });
    }


    @Test
    void findById() {
        Long id = 1L;
        ProductInfoDTO expected = new ProductInfoDTO(Optional.of(new Product(id, "Product 1", "Description 1", BigDecimal.valueOf(10.0))));
        when(productRepository.findById(any())).thenReturn(Optional.of(new Product(id, "Product 1", "Description 1", BigDecimal.valueOf(10.0))));
        ProductInfoDTO result = service.findById(id);
        assertEquals(expected.getDescription(), result.getDescription());
        assertEquals(expected.getProductName(), result.getProductName());
        assertEquals(expected.getUnitaryValue(), result.getUnitaryValue());
    }

    @Test
    void findById_is_Empty() {
        assertThrows(ObjectNotFound.class, () ->{
            service.findById(1L);
        });
    }

}













