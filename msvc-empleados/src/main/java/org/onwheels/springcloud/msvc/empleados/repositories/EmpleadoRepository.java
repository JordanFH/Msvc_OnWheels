package org.onwheels.springcloud.msvc.empleados.repositories;

import org.onwheels.springcloud.msvc.empleados.models.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
}
