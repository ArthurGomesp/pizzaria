package com.Gomes.pizzaria.services;

import com.Gomes.pizzaria.domain.Pedido;
import com.Gomes.pizzaria.domain.dto.PedidoDTO;
import com.Gomes.pizzaria.domain.dto.PedidoInfoDTO;

public interface PedidoService {
    PedidoInfoDTO create(PedidoDTO pedidoDTO);
}
