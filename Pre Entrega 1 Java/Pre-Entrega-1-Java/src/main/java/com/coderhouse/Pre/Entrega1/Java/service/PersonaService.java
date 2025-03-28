package com.coderhouse.Pre.Entrega1.Java.service;

import org.springframework.stereotype.Service;

import com.coderhouse.Pre.Entrega1.Java.entity.Persona;
import com.coderhouse.Pre.Entrega1.Java.repository.PersonaRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public Optional<Persona> actualizar(Long id, Persona personaActualizada) {
        return personaRepository.findById(id).map(persona -> {
            persona.setNombre(personaActualizada.getNombre());
            persona.setCorreo(personaActualizada.getCorreo());
            return personaRepository.save(persona);
        });
    }

    public void eliminar(Long id) {
        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Persona con ID " + id + " no encontrada");
        }
    }
}
