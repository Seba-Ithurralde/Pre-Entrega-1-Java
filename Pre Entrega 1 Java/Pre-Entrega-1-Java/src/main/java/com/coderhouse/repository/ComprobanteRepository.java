package com.coderhouse.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.entity.Comprobante;

public interface ComprobanteRepository extends JpaRepository<Comprobante, Long> {
}
