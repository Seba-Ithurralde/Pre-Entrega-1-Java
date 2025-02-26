package com.coderhouse.Pre.Entrega1.Java;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Optional<Persona> findByCorreo(String correo);

    Optional<Persona> findByNombre(String nombre);
}
