package com.unapec.cajaunapec.repositories;

import com.unapec.cajaunapec.entities.TiposDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposDocumentoRepository extends JpaRepository<TiposDocumento, Long> {
}