package com.example.demo.infrastructure;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumidorEventTransaccion {

    public ConsumidorEventTransaccion() {
    }

    @KafkaListener(topics = "transaccion", groupId = "grupo_transacciones")
    public void consumirEventoTransaccion(String mensaje) {
        System.out.println("Evento recibido: " + mensaje);
    }
}
