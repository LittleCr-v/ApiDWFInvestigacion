package com.dwfin.event;

import com.dwfin.model.Empleado;
import org.springframework.context.ApplicationEvent;

public class EmpleadoCreado extends ApplicationEvent {
    private final Empleado empleado;

    public EmpleadoCreado(Object source, Empleado empleado) {
        super(source);
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
}
