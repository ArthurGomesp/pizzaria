package com.Gomes.pizzaria.domain.dto;

import com.Gomes.pizzaria.domain.ObjectPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class PedidoInfoDTO {

    private Long userId;
    private String userName;
    private List<ObjectPedido> objectPedidoList;
    private BigDecimal totalValue;

    public PedidoInfoDTO(String name, PedidoDTO pedidoDTO, BigDecimal totalValue) {
        this.userId = pedidoDTO.getUserId();
        this.userName = name;
        this.objectPedidoList = pedidoDTO.getObjectPedidoList();
        this.totalValue = totalValue;
    }
}
