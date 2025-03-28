package com.coderhouse.Pre.Entrega1.Java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.Pre.Entrega1.Java.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

