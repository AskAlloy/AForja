package com.horizon.Cosplayforge.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horizon.Cosplayforge.model.Pedido;
import com.horizon.Cosplayforge.model.StatusPedido;

public interface PedidoRepository extends JpaRepository <Pedido, Long> {

	// Para listar os pedidos do cliente
    List<Pedido> findByClienteIdOrderByDataCriacaoDesc(UUID clienteId);
	
 // Cliente só enxerga pedido que é dele (acesso a dados de outro usuário)
    Optional<Pedido> findByIdAndClienteId(Long id, UUID clienteId);
 
    // RF013: pedidos da loja do vendedor
    List<Pedido> findByLojaIdOrderByDataCriacaoDesc(Long lojaId);
 
    List<Pedido> findByLojaIdAndStatusOrderByDataCriacaoDesc(Long lojaId, StatusPedido status);
 
    // Vendedor só altera pedido da própria loja
    Optional<Pedido> findByIdAndLojaId(Long id, Long lojaId);
}
