package org.onwheels.springcloud.msvc.empleados.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.onwheels.springcloud.msvc.empleados.models.entity.Empleado;
import org.onwheels.springcloud.msvc.empleados.repositories.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> listar() {
        return (List<Empleado>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Empleado> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Empleado guardar(Empleado empleado) {
        return repository.save(empleado);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
