package com.dwfin.service;

import com.dwfin.event.EmpleadoCreado;
import com.dwfin.event.EmpleadoActualizado;
import com.dwfin.event.EmpleadoEliminado;
import com.dwfin.exception.EmpleadoNotFoundException;
import com.dwfin.model.Empleado;
import com.dwfin.kafka.EmpleadoKafkaProducer;
import com.dwfin.repository.EmpleadoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final EmpleadoKafkaProducer empleadoKafkaProducer;
    private final NotificacionService notificacionService;

    public EmpleadoService(EmpleadoRepository empleadoRepository, ApplicationEventPublisher eventPublisher, EmpleadoKafkaProducer kafkaProducer, NotificacionService notificacionService) {
        this.empleadoRepository = empleadoRepository;
        this.eventPublisher = eventPublisher;
        this.empleadoKafkaProducer = kafkaProducer;
        this.notificacionService = notificacionService;
    }

    // Crear empleado
    public Empleado crearEmpleado(Empleado empleado) {
        Empleado guardado = empleadoRepository.save(empleado);

        eventPublisher.publishEvent(new EmpleadoCreado(this, guardado));

        empleadoKafkaProducer.sendMessage("empleados-creados", String.valueOf(guardado.getId()),guardado.getNombre());

        notificacionService.enviarCorreoBienvenida(guardado.getNombre());
        return guardado;
    }

    public List<Empleado> obtenerTodo() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> obtenerPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado obtenerPorIdOrThrow(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNotFoundException(id));
    }

    public Empleado actualizar(Long id, Empleado empleado) {
        empleado.setId(id);
        Empleado actualizado = empleadoRepository.save(empleado);

        eventPublisher.publishEvent(new EmpleadoActualizado(this, actualizado));

        empleadoKafkaProducer.sendMessage("empleados-creados",String.valueOf(actualizado.getId()),actualizado.getNombre());
        return actualizado;
    }

    public void eliminar(Long id) {
        empleadoRepository.findById(id).ifPresent(empleado -> {
            empleadoRepository.delete(empleado);

            eventPublisher.publishEvent(new EmpleadoEliminado(this, empleado));

            empleadoKafkaProducer.sendMessage("empleados-creados",String.valueOf(empleado.getId()),empleado.getNombre());
        });
    }
}