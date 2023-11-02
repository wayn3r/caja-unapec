package com.unapec.cajaunapec.repositories;

import com.unapec.cajaunapec.entities.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {
    // Puedes agregar métodos personalizados de búsqueda o consulta aquí si es necesario
}
