package com.coderhouse.Pre.Entrega1.Java.entity;

import jakarta.persistence.*;

@Entity
public class Linea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Producto producto;

    private int cantidad;
    private double precioUnitario;

    public Linea() {}

    public Linea(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = producto.getPrecio(); // Guarda el precio original
    }

    public Long getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPrecioUnitario'");
    }

    public void setProducto(Producto producto2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setProducto'");
    }

    public void setCantidad(int cantidad2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCantidad'");
    }
}

