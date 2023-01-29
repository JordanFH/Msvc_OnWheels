package org.onwheels.springcloud.msvc.empleados.services;

import org.onwheels.springcloud.msvc.empleados.models.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> listar();

    Optional<Empleado> buscarPorId(Long id);

    Empleado guardar(Empleado empleado);

    void eliminar(Long id);
}
