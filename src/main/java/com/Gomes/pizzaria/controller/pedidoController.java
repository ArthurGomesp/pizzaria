package com.Gomes.pizzaria.controller;

import com.Gomes.pizzaria.domain.Pedido;
import com.Gomes.pizzaria.domain.Product;
import com.Gomes.pizzaria.domain.dto.PedidoDTO;
import com.Gomes.pizzaria.domain.dto.ProductCreateDTO;
import com.Gomes.pizzaria.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class pedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity create(@RequestBody PedidoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.create(dto));
    }}
