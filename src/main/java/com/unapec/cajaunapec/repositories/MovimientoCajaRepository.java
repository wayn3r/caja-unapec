package com.unapec.cajaunapec.repositories;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.MovimientoCaja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoCajaRepository extends JpaRepository<MovimientoCaja, Long> {

    List<MovimientoCaja> findByEstado(Estado estado);
}
