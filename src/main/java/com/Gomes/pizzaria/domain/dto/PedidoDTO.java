package com.Gomes.pizzaria.domain.dto;


import com.Gomes.pizzaria.domain.ObjectPedido;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class PedidoDTO {
    @NotNull
    private Long userId;
    @NotNull
    private List<ObjectPedido> objectPedidoList;
}
