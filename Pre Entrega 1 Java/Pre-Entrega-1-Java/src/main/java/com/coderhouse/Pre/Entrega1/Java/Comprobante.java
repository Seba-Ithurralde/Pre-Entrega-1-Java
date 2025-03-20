package com.coderhouse.Pre.Entrega1.Java;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Linea> lineas;

    private Date fecha;
    private double total;
    private int cantidadTotal;

    public Comprobante() {}

    public Comprobante(Cliente cliente, List<Linea> lineas, Date fecha, double total, int cantidadTotal) {
        this.cliente = cliente;
        this.lineas = lineas;
        this.fecha = fecha;
        this.total = total;
        this.cantidadTotal = cantidadTotal;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getTotal() {
        return total;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }
}
