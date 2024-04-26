package com.Gomes.pizzaria.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectPedido {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToOne @JsonIgnore
    private Pedido pedido;
    private Long productId;
    private Integer amount;


    public ObjectPedido(Pedido pedido, Long productId, Integer amount) {
        this.pedido = pedido;
        this.productId = productId;
        this.amount = amount;
    }
}
