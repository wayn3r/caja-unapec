package com.unapec.cajaunapec.repositories;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.ModalidadPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModalidadesPagoRepository extends JpaRepository<ModalidadPago, Long> {
    List<ModalidadPago> findByEstado(Estado estado);
}