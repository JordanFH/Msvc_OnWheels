package org.onwheels.springcloud.msvc.empleados.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.onwheels.springcloud.msvc.empleados.models.entity.Empleado;
import org.onwheels.springcloud.msvc.empleados.services.EmpleadoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService service;

    @GetMapping
    public ResponseEntity<List<Empleado>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Empleado> optional = service.buscarPorId(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    private ResponseEntity<?> crear(@Valid @RequestBody Empleado empleado, BindingResult result) {
        if (result.hasErrors()) {
            return validar(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(empleado));
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> editar(@Valid @RequestBody Empleado empleado, @PathVariable Long id, BindingResult result) {
        if (result.hasErrors()) {
            return validar(result);
        }
        Optional<Empleado> optional = service.buscarPorId(id);
        if (optional.isPresent()) {
            Empleado empleadoDb = optional.get();
            empleadoDb.setNombre(empleado.getNombre());
            empleadoDb.setApePaterno(empleado.getApePaterno());
            empleadoDb.setApeMaterno(empleado.getApeMaterno());
            empleadoDb.setFechaNacimiento(empleado.getFechaNacimiento());
            empleadoDb.setFechaInicioContrato(empleado.getFechaInicioContrato());
            empleadoDb.setFechaVenceContrato(empleado.getFechaVenceContrato());
            empleadoDb.setDni(empleado.getDni());
            empleadoDb.setTelefono(empleado.getTelefono());
            empleadoDb.setDireccion(empleado.getDireccion());
            empleadoDb.setEmail(empleado.getEmail());
            empleadoDb.setPassword(empleado.getPassword());
            empleadoDb.setCargo(empleado.getCargo());
            empleadoDb.setCiudad(empleado.getCiudad());
            empleadoDb.setRegion(empleado.getRegion());
            empleadoDb.setPais(empleado.getPais());
            empleadoDb.setActivo(empleado.isActivo());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(empleadoDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Empleado> optional = service.buscarPorId(id);
        if (optional.isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private static ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }
}
