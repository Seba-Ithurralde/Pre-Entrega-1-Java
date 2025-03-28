package com.coderhouse.Pre.Entrega1.Java.dto;

import java.util.Date;

public class ComprobanteResponseDTO {
    private String mensaje;
    private Date fecha;
    private double totalVenta;
    private int cantidadTotal;

    public ComprobanteResponseDTO(String mensaje, Date fecha, double totalVenta, int cantidadTotal) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
        this.cantidadTotal = cantidadTotal;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }
}

