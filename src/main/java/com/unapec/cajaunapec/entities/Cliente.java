package com.unapec.cajaunapec.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotNull(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotNull(message = "El tipo de cliente no puede estar vacío")
    private TiposCliente tipoCliente;

    @NotNull(message = "La carrera no puede estar vacía")
    @Size(min = 3, max = 50, message = "La carrera debe tener entre 3 y 50 caracteres")
    private String carrera;

    @NotNull(message = "La fecha de registro no puede estar vacía")
    @Past(message = "La fecha de registro debe ser anterior a la fecha actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fRegistro;

    @NotNull(message = "El estado no puede estar vacío")
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
