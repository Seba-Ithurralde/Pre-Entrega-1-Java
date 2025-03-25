package com.coderhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.coderhouse.dto.ComprobanteRequestDTO;
import com.coderhouse.dto.ComprobanteResponseDTO;
import com.coderhouse.entity.Cliente;
import com.coderhouse.entity.Comprobante;
import com.coderhouse.entity.Linea;
import com.coderhouse.entity.Producto;
import com.coderhouse.repository.ClienteRepository;
import com.coderhouse.repository.ComprobanteRepository;
import com.coderhouse.repository.ProductoRepository;

import java.util.Date;
import java.util.List;

import java.util.stream.Collectors;

@Service
public class ComprobanteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ComprobanteRepository comprobanteRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional
    public ComprobanteResponseDTO crearComprobante(ComprobanteRequestDTO requestDTO) {
        try {
            // 1️⃣ Valido que el cliente exista
            Cliente cliente = clienteRepository.findById(requestDTO.getCliente().getClienteid())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

            // 2️⃣ Valido productos, stock y calculo el total
            final double[] totalVenta = {0.0};
            final int[] totalProductos = {0};

            List<Linea> lineas = requestDTO.getLineas().stream().map(lineaDTO -> {
                Producto producto = productoRepository.findById(lineaDTO.getProducto().getProductoid())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

                // 3️⃣ Verifico stock disponible
                if (lineaDTO.getCantidad() > producto.getStock()) {
                    throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombre());
                }

                // 4️⃣ Reduzco el stock
                producto.setStock(producto.getStock() - lineaDTO.getCantidad());
                productoRepository.save(producto);

                // 5️⃣ Creo la línea del comprobante y mantengo el precio original
                Linea linea = new Linea();
                linea.setCantidad(lineaDTO.getCantidad());
                linea.setProducto(producto);
                linea.setPrecioUnitario(producto.getPrecio()); // Mantengo el precio original

                // 6️⃣ Calculo totales
                totalVenta[0] += producto.getPrecio() * lineaDTO.getCantidad();
                totalProductos[0] += lineaDTO.getCantidad();

                return linea;
            }).collect(Collectors.toList());

            // 7️⃣ Obtengo la fecha desde un servicio externo o uso la fecha local
            Date fechaComprobante = obtenerFechaDesdeServicio();

            // 8️⃣ Creo y guardo el comprobante
            Comprobante comprobante = new Comprobante();
            comprobante.setCliente(cliente);
            comprobante.setLineas(lineas);
            comprobante.setFecha(fechaComprobante);
            comprobante.setTotal(totalVenta[0]);
            comprobante.setCantidadTotal(totalProductos[0]);

            comprobanteRepository.save(comprobante);

            // 9️⃣ Armo una respuesta
            return new ComprobanteResponseDTO(
                    "Comprobante creado exitosamente",
                    fechaComprobante,
                    totalVenta[0],
                    totalProductos[0]
            );

        } catch (Exception error) {
            return new ComprobanteResponseDTO("Error: " + error.getMessage(), null, 0.0, 0);
        }
    }

    private Date obtenerFechaDesdeServicio() {
        try {
            return restTemplate.getForObject("https://worldtimeapi.org/api/timezone/America/Argentina/Buenos_Aires", Date.class);
        } catch (Exception error) {
            System.out.println("Error al obtener la fecha del servicio REST. Se usará la fecha local.");
            return new Date();
        }
    }
}
