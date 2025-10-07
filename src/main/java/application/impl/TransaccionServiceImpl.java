package application.impl;

import application.TransaccionService;
import domain.modelo.Transaccion;
import domain.puertos.TansaccionRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    private final TansaccionRepository transaccionRepository;
    private final KafkaTemplate<String, Transaccion> kafkaTemplate;
    private final String topic;


    //Constructor con un Productor, se utiliza kafka template
    public TransaccionServiceImpl(TansaccionRepository transaccionRepository, KafkaTemplate<String, Transaccion> kafkaTemplate,
                                  String topic) {
        this.transaccionRepository = transaccionRepository;
        this.kafkaTemplate = kafkaTemplate;
        this.topic = "transaccion";
    }

    //Se envía el evento en un topic
    @Override
    public Transaccion ejecutarTransaccion(Transaccion transaccion) {
        kafkaTemplate.send(topic, transaccion);
        System.out.println("Evento de transacción publicado en Kafka: " + transaccion);
        return this.transaccionRepository.save(transaccion);
    }
}
