package com.Gomes.pizzaria.domain.dto;


import com.Gomes.pizzaria.domain.ObjectPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class PedidoDTO {
    private Long userId;
    private List<ObjectPedido> objectPedidoList;
}
