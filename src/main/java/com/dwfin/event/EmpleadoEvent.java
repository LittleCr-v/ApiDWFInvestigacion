package com.dwfin.event;

import com.dwfin.model.Empleado;
import org.springframework.context.ApplicationEvent;

public class EmpleadoEvent extends ApplicationEvent {
    private final Empleado empleado;
    private final String tipoEvento; //

    public EmpleadoEvent(Object source, Empleado empleado, String tipoEvento) {
        super(source);
        this.empleado = empleado;
        this.tipoEvento = tipoEvento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }
}
