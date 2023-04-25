package com.gcontreras.springFramework.proyectJPA.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PruebaKafkaListener {
    private static final Logger log = LoggerFactory.getLogger(PruebaKafkaListener.class);

    /**
     * Lectura de mensajes de broker de kafka del topic creado "prueba-topic"
     */
    @KafkaListener(topics = "prueba-topic", groupId = "PruebaGroup")
    public void listen(String message){
        log.info("Message received: {}", message);
    }
}
