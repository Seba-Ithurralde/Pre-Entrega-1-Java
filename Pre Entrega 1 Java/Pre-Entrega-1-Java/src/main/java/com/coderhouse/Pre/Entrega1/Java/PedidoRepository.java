package com.coderhouse.Pre.Entrega1.Java;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    List<Pedido> findByPersonaId(Long personaId);
}
