package com.Gomes.pizzaria.services.impl;

import com.Gomes.pizzaria.domain.ObjectPedido;
import com.Gomes.pizzaria.domain.Pedido;
import com.Gomes.pizzaria.domain.Product;
import com.Gomes.pizzaria.domain.User;
import com.Gomes.pizzaria.domain.dto.PedidoDTO;
import com.Gomes.pizzaria.domain.dto.PedidoInfoDTO;
import com.Gomes.pizzaria.repositories.ObjectPedidoRepository;
import com.Gomes.pizzaria.repositories.PedidoRepository;
import com.Gomes.pizzaria.repositories.ProductRepository;
import com.Gomes.pizzaria.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PedidoServiceImplTest {

    @InjectMocks
    private PedidoServiceImpl pedidoService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private ObjectPedidoRepository objectPedidoRepository;

    @Mock
    private userServiceImpl userServiceImpl;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void test_create_valid_user_id_and_object_pedido_list() {
        // Arrange
        Long userId = 1L;
        List<ObjectPedido> objectPedidoList = new ArrayList<>();
        objectPedidoList.add(new ObjectPedido(new Pedido(), 1L, 2));
        PedidoDTO pedidoDTO = new PedidoDTO(userId, objectPedidoList);

        User user = new User();
        user.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Product product = new Product();
        product.setId(1L);
        product.setUnitaryValue(BigDecimal.TEN);
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Pedido pedido = new Pedido();
        pedido.setUserId(userId);
        pedido.setObjectPedidoList(objectPedidoList);
        pedido.setTotal(BigDecimal.TEN.multiply(BigDecimal.valueOf(2)));
        when(pedidoRepository.save(any())).thenReturn(pedido);

        PedidoInfoDTO expected = new PedidoInfoDTO(user.getName(), pedidoDTO, pedido.getTotal());

        when(userServiceImpl.verifyStatusAccount(any())).thenReturn(true);
        when(objectPedidoRepository.save(any(ObjectPedido.class))).thenReturn(new ObjectPedido());

        // Act
        PedidoInfoDTO result = pedidoService.create(pedidoDTO);

        // Assert
        assertEquals(expected.getUserId(), result.getUserId());
        assertEquals(expected.getUserName(), result.getUserName());
        assertEquals(expected.getObjectPedidoList(), result.getObjectPedidoList());
    }

}