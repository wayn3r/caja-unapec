package com.unapec.cajaunapec.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "servicios_facturables")
public class ServicioFacturable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void remove(){
        setEstado(Estado.INACTIVO);
    }

    public Boolean getEstaActivo() {
        return estado == Estado.ACTIVO;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Estado getEstado() {
        return estado   ;
    }
}
