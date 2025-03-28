package com.coderhouse.Pre.Entrega1.Java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coderhouse.Pre.Entrega1.Java.dto.ComprobanteRequestDTO;
import com.coderhouse.Pre.Entrega1.Java.dto.ComprobanteResponseDTO;
import com.coderhouse.Pre.Entrega1.Java.service.ComprobanteService;

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

