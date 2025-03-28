package com.coderhouse.Pre.Entrega1.Java.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.Pre.Entrega1.Java.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
