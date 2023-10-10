package com.unapec.cajaunapec.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombre;
    private TiposCliente tipoCliente;
    private String carrera;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fRegistro;
    private Estado estado;

    // Getters y setters
    public void remove(){
        setEstado(Estado.INACTIVO);
    }

    public Boolean getEstaActivo() {
        return estado == Estado.ACTIVO;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TiposCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TiposCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public LocalDate getfRegistro() {
        return fRegistro;
    }

    public void setfRegistro(LocalDate fRegistro) {
        this.fRegistro = fRegistro;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
