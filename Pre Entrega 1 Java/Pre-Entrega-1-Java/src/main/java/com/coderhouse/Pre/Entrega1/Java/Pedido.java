package com.coderhouse.Pre.Entrega1.Java;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    
    public Pedido() {}

    public Pedido(String descripcion, Persona persona) {
        this.descripcion = descripcion;
        this.fechaHora = LocalDateTime.now();
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}

