package com.Gomes.pizzaria.domain;

import com.Gomes.pizzaria.domain.dto.PedidoDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<ObjectPedido> getObjectPedidoList() {
        return objectPedidoList;
    }

    public void setObjectPedidoList(List<ObjectPedido> objectPedidoList) {
        this.objectPedidoList = objectPedidoList;
    }
}
