package infrastructure;

import org.springframework.kafka.annotation.KafkaListener;

public class ConsumidorEventTransaccion {

    public ConsumidorEventTransaccion() {
    }

    @KafkaListener(topics = "transaccion", groupId = "grupo_transacciones")
    public void consumirEventoTransaccion(String mensaje) {
        System.out.println("Evento recibido: " + mensaje);
    }
}
