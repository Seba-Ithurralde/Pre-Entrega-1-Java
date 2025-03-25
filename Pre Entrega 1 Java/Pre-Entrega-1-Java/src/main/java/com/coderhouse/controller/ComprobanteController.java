package com.coderhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coderhouse.dto.ComprobanteRequestDTO;
import com.coderhouse.dto.ComprobanteResponseDTO;
import com.coderhouse.service.ComprobanteService;

@RestController
@RequestMapping("/comprobantes")
public class ComprobanteController {

    @Autowired
    private ComprobanteService comprobanteService;

    @PostMapping
    public ResponseEntity<ComprobanteResponseDTO> crearComprobante(@RequestBody ComprobanteRequestDTO requestDTO) {
        ComprobanteResponseDTO comprobante = comprobanteService.crearComprobante(requestDTO);
        return ResponseEntity.ok(comprobante);
    }
}

