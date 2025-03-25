package com.coderhouse.entity;

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

    public void setCliente(Cliente cliente2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCliente'");
    }

    public void setLineas(List<Linea> lineas2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLineas'");
    }

    public void setFecha(Date fechaComprobante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setFecha'");
    }

    public void setTotal(double totalVenta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTotal'");
    }

    public void setCantidadTotal(int totalProductos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCantidadTotal'");
    }
}
