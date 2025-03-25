package com.coderhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.entity.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    List<Pedido> findByPersonaId(Long personaId);
}
