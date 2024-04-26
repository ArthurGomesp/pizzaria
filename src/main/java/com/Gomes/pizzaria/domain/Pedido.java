package com.Gomes.pizzaria.domain;

import com.Gomes.pizzaria.domain.dto.PedidoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @OneToMany
    private List<ObjectPedido> objectPedidoList;
    private BigDecimal total;

    public Pedido() {
    }

    public Pedido(Long id, Long userId, List<ObjectPedido> objectPedidoList, BigDecimal total) {
        this.id = id;
        this.userId = userId;
        this.objectPedidoList = objectPedidoList;
        this.total = total;
    }

    public Pedido(Long userId, PedidoDTO pedidoDTO, BigDecimal totalValue) {
        this.userId = userId;
        this.objectPedidoList = pedidoDTO.getObjectPedidoList();
        this.total = totalValue;
    }

}
