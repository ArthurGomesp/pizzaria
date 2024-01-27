package com.Gomes.pizzaria.services.impl;

import com.Gomes.pizzaria.domain.ObjectPedido;
import com.Gomes.pizzaria.domain.Pedido;
import com.Gomes.pizzaria.domain.Product;
import com.Gomes.pizzaria.domain.dto.PedidoDTO;
import com.Gomes.pizzaria.domain.dto.PedidoInfoDTO;
import com.Gomes.pizzaria.domain.dto.ProductInfoDTO;
import com.Gomes.pizzaria.exception.DisabledAccountException;
import com.Gomes.pizzaria.exception.ObjectNotFound;
import com.Gomes.pizzaria.repositories.ObjectPedidoRepository;
import com.Gomes.pizzaria.repositories.PedidoRepository;
import com.Gomes.pizzaria.repositories.ProductRepository;
import com.Gomes.pizzaria.repositories.UserRepository;
import com.Gomes.pizzaria.services.PedidoService;
import com.Gomes.pizzaria.services.ProductService;
import com.Gomes.pizzaria.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private userServiceImpl userServiceImpl;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ObjectPedidoRepository objectPedidoRepository;


    @Override
    public PedidoInfoDTO create(PedidoDTO pedidoDTO) {
        if (userRepository.findById(pedidoDTO.getUserId()).isPresent()) {
            if (userServiceImpl.verifyStatusAccount(userRepository.findById(pedidoDTO.getUserId()))) {
                BigDecimal totalValue = BigDecimal.ZERO;
                List<ObjectPedido> objectPedidoList = pedidoDTO.getObjectPedidoList();
                List<ObjectPedido> savedObjectPedidos = new ArrayList<>();

                for (ObjectPedido objectPedido : objectPedidoList){
                    Optional<Product> productOptional = productRepository.findById(objectPedido.getProductId());
                    if(productOptional.isPresent()){
                        totalValue = totalValue.add(productOptional.get().getUnitaryValue());
                        savedObjectPedidos.add(objectPedidoRepository.save(objectPedido));

                    }else {
                        throw new ObjectNotFound("Objeto não encontrado.");
                    }

                }
                Pedido pedido = new Pedido(pedidoDTO.getUserId(), pedidoDTO, totalValue);
                pedidoRepository.save(pedido);
                return new PedidoInfoDTO(userRepository.findById(pedidoDTO.getUserId()).get().getName(), pedidoDTO, totalValue);
            } else {
                throw new DisabledAccountException("Esta conta foi desativada!");

            }
        } else {
            throw new ObjectNotFound("Objeto não encontrado.");
        }
    }
}
