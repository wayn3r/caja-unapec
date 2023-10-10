package com.unapec.cajaunapec.repositories;

import com.unapec.cajaunapec.entities.Cliente;
import com.unapec.cajaunapec.entities.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByEstado(Estado estado);
}
