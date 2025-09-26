package com.dwfin.event;

import com.dwfin.model.Empleado;
import org.springframework.context.ApplicationEvent;

public class EmpleadoEliminado extends ApplicationEvent {
    private final Empleado empleado;

    public EmpleadoEliminado(Object source, Empleado empleado) {
        super(source);
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
}
