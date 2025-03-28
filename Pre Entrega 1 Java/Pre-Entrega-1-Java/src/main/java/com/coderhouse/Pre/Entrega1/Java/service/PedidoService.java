package com.coderhouse.Pre.Entrega1.Java.service;

import org.springframework.stereotype.Service;

import com.coderhouse.Pre.Entrega1.Java.entity.Pedido;
import com.coderhouse.Pre.Entrega1.Java.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido actualizar(Long id, Pedido pedidoActualizado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setDescripcion(pedidoActualizado.getDescripcion());
            pedido.setFechaHora(pedidoActualizado.getFechaHora());
            pedido.setPersona(pedidoActualizado.getPersona());
            return pedidoRepository.save(pedido);
        }).orElseThrow(() -> new IllegalArgumentException("Pedido con ID " + id + " no encontrado"));
    }

    public void eliminar(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pedido con ID " + id + " no encontrado");
        }
    }

    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}