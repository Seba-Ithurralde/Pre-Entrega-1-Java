package com.coderhouse.Pre.Entrega1.Java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.Pre.Entrega1.Java.entity.Pedido;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    List<Pedido> findByPersonaId(Long personaId);
}
