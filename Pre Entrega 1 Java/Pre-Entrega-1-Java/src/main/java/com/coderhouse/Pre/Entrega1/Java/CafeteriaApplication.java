package com.coderhouse.Pre.Entrega1.Java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    public void run(String... args) throws Exception {
        // Crear personas
        Persona persona1 = new Persona("Juan Pérez", "juan@email.com");
        Persona persona2 = new Persona("Ana González", "ana@email.com");

        // Guardar personas en la base de datos
        personaRepository.save(persona1);
        personaRepository.save(persona2);

        // Crear pedidos
        Pedido pedido1 = new Pedido("Café con leche", persona1);
        Pedido pedido2 = new Pedido("Café moca", persona2);

        // Guardar pedidos en la base de datos
        pedidoRepository.save(pedido1);
        pedidoRepository.save(pedido2);

        // Imprimir mensaje de confirmación
        System.out.println("Datos guardados correctamente en la base de datos.");
    }
}
