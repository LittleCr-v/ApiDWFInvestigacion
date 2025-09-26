package com.dwfin.kafka;

import com.dwfin.model.Empleado;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class EmpleadoKafkaProducer {

    public static final String TOPIC_EMPLEADOS_CREADOS = "empleados-creados";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public EmpleadoKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void sendEmpleado(Empleado empleado) {
        try {
            String payload = objectMapper.writeValueAsString(empleado);
            String key = empleado.getId() != null ? String.valueOf(empleado.getId()) : null;
            sendMessage(TOPIC_EMPLEADOS_CREADOS, key, payload);
        } catch (JsonProcessingException e) {
            // loguea el fallo de serialización
            System.err.println("Error serializando Empleado para Kafka: " + e.getMessage());
        }
    }

    public void sendMessage(String topic, String key, String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, message);

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.printf("✅ Mensaje enviado a Kafka topic=%s, key=%s, offset=%d%n",
                        topic, key, result.getRecordMetadata().offset());
            } else {
                System.err.printf("❌ Error al enviar mensaje a Kafka topic=%s: %s%n", topic, ex.getMessage());
            }
        });
    }
}
