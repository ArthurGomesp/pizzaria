package com.Gomes.pizzaria.repositories;

import com.Gomes.pizzaria.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
