package com.unapec.cajaunapec.repositories;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormasPagoRepository extends JpaRepository<FormaPago, Long> {
    List<FormaPago> findByEstado(Estado estado);
}