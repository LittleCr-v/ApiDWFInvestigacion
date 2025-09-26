package com.dwfin.listener;

import com.dwfin.event.EmpleadoCreado;
import com.dwfin.event.EmpleadoActualizado;
import com.dwfin.event.EmpleadoEliminado;
import com.dwfin.kafka.EmpleadoKafkaProducer;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoEventListener {

    private final EmpleadoKafkaProducer kafkaProducer;

    public EmpleadoEventListener(EmpleadoKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Async
    @EventListener
    public void manejarEmpleadoCreado(EmpleadoCreado event) throws InterruptedException{
        Thread.sleep(5000);
        System.out.println("✓ [Async] Empleado creado: " + event.getEmpleado().getNombre());
        kafkaProducer.sendEmpleado(event.getEmpleado());
    }

    @Async
    @EventListener
    public void manejarEmpleadoActualizado(EmpleadoActualizado event) throws InterruptedException{
        Thread.sleep(5000);
        System.out.println("✓ [Async] Empleado actualizado: " + event.getEmpleado().getNombre());
    }

    @Async
    @EventListener
    public void manejarEmpleadoEliminado(EmpleadoEliminado event) throws InterruptedException{
        Thread.sleep(5000);
        System.out.println("✓ [Async] Empleado eliminado: " + event.getEmpleado().getNombre());
    }
}
