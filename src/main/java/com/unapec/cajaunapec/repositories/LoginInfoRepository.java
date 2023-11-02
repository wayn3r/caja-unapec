package com.unapec.cajaunapec.repositories;

import com.unapec.cajaunapec.entities.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginInfoRepository extends JpaRepository<LoginInfo, Long> {
    // Puedes agregar métodos personalizados de consulta aquí si es necesario
}
