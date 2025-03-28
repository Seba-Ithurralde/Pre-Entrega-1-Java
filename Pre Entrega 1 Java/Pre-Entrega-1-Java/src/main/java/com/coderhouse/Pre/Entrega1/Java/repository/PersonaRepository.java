package com.coderhouse.Pre.Entrega1.Java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.Pre.Entrega1.Java.entity.Persona;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Optional<Persona> findByCorreo(String correo);

    Optional<Persona> findByNombre(String nombre);
}
