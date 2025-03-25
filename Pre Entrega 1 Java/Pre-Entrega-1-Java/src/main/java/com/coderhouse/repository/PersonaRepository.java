package com.coderhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.entity.Persona;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Optional<Persona> findByCorreo(String correo);

    Optional<Persona> findByNombre(String nombre);
}
