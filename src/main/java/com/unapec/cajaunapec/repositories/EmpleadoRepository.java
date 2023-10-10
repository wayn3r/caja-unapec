package com.unapec.cajaunapec.repositories;

import com.unapec.cajaunapec.entities.Empleado;
import com.unapec.cajaunapec.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByEstado(Estado estado);
}
