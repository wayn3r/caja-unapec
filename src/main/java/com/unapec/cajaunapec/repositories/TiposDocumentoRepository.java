package com.unapec.cajaunapec.repositories;

import com.unapec.cajaunapec.entities.Estado;
import com.unapec.cajaunapec.entities.TiposDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiposDocumentoRepository extends JpaRepository<TiposDocumento, Long> {
    List<TiposDocumento> findByEstado(Estado estado);
}