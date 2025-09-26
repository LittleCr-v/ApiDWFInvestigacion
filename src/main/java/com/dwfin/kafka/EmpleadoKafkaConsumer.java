package com.dwfin.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class EmpleadoKafkaConsumer {

    @KafkaListener(topics = "empleados-creados", groupId = "empleados-group")
    public void consumirEvento(String mensaje){
        System.out.println("Evento Kafka recibido: " + mensaje);
    }
}
