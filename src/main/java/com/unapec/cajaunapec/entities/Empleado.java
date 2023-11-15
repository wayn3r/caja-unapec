package com.unapec.cajaunapec.entities;

import java.time.LocalDate;

import com.unapec.cajaunapec.validations.Cedula;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede estar vacío")
    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @NotNull(message = "La cedula no puede estar vacía")
    @NotEmpty(message = "La cedula no puede estar vacía")
    @Cedula(message = "La cedula no es válida")
    private String cedula;

    @NotNull(message = "La tanda laboral no puede estar vacía")
    private TandasLabor tandaLabor;

    @NotNull(message = "La fecha de ingreso no puede estar vacía")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    @NotNull(message = "El estado no puede estar vacío")
    private Estado estado;

    public void remove(){
        setEstado(Estado.INACTIVO);
    }

    public Boolean getEstaActivo() {
        return estado == Estado.ACTIVO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public TandasLabor getTandaLabor() {
        return tandaLabor;
    }

    public void setTandaLabor(TandasLabor tandaLabor) {
        this.tandaLabor = tandaLabor;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}

