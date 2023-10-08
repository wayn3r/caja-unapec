package com.unapec.cajaunapec.repositories;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.ServicioFacturable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiciosFacturablesRepository extends JpaRepository<ServicioFacturable, Long> {
    List<ServicioFacturable> findByEstado(Estado estado);
}