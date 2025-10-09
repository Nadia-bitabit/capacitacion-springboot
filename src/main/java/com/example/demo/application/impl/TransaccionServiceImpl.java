package com.example.demo.application.impl;

import com.example.demo.application.TransaccionService;
import com.example.demo.domain.modelo.Transaccion;
import com.example.demo.domain.puertos.TansaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private final TansaccionRepository transaccionRepository;
    @Autowired
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final String topic;


    //Constructor con un Productor, se utiliza kafka template
    @Autowired
    public TransaccionServiceImpl(TansaccionRepository transaccionRepository, KafkaTemplate<String, Object> kafkaTemplate) {
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
