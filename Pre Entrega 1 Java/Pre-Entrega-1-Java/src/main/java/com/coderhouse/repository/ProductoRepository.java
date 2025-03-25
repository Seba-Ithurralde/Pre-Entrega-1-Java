package com.coderhouse.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
