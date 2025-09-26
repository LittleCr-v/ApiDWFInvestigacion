package com.dwfin.controller;

import com.dwfin.model.Empleado;
import com.dwfin.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> obtenerTodos() {
        return empleadoService.obtenerTodo();
    }

    @GetMapping("/{id}")
    public Empleado obtenerPorId(@PathVariable long id) {
        return empleadoService.obtenerPorIdOrThrow(id);
    }

    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        return empleadoService.crearEmpleado(empleado);
    }

    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Long id, @RequestBody Empleado empleado) {
        return empleadoService.actualizar(id, empleado);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        empleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
