package com.dwfin.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    @Async
    public void enviarCorreoBienvenida(String nombreEmpleado){
        try{
            Thread.sleep(3000); //Se simula una tarea
            System.out.println(("Correo de bienvenida enviado a "+nombreEmpleado));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
