package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.entity.Pedido;
import com.coderhouse.entity.Persona;
import com.coderhouse.repository.PedidoRepository;
import com.coderhouse.repository.PersonaRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class CafeteriaApplication implements CommandLineRunner {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CafeteriaApplication.class, args);
    }
    
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Creo y guardo personas
        Persona persona1 = personaRepository.save(new Persona("Juan Pérez", "juan@email.com"));
        Persona persona2 = personaRepository.save(new Persona("Ana González", "ana@email.com"));
    
        // Recupero las personas desde la base de datos para asegurarse de que están gestionadas
        persona1 = personaRepository.findById(persona1.getId()).orElseThrow();
        persona2 = personaRepository.findById(persona2.getId()).orElseThrow();
    
        // Creo pedidos con personas gestionadas
        Pedido pedido1 = new Pedido("Café con leche", persona1);
        Pedido pedido2 = new Pedido("Café moca", persona2);
    
        // Guardo pedidos en la base de datos
        pedidoRepository.save(pedido1);
        pedidoRepository.save(pedido2);
    
        // Imprimo mensaje de confirmación
        System.out.println("Datos guardados correctamente en la base de datos");
    }
}
