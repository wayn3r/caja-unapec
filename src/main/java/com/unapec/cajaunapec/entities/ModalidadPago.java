package com.unapec.cajaunapec.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "modalidad_pagos")
public class ModalidadPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    @NotNull(message = "La descripción no puede estar vacía")
    @NotEmpty(message = "La descripción no puede estar vacía")
    @Size(max = 50, message = "La descripción no puede tener más de 50 caracteres")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    @NotNull(message = "El estado no puede estar vacío")
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
