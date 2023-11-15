package com.unapec.cajaunapec.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Entity
public class MovimientoCaja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true)
    @NotNull(message = "El número de movimiento no puede estar vacío")
    @NotEmpty(message = "El número de movimiento no puede estar vacío")
    private String noMovimiento;

    @ManyToOne
    @NotNull(message = "El empleado no puede estar vacío")
    private Empleado empleado;

    @ManyToOne
    @NotNull(message = "El cliente no puede estar vacío")
    private Cliente cliente;

    @ManyToOne
    @NotNull(message = "El servicio no puede estar vacío")
    private ServicioFacturable servicio;

    @ManyToOne
    @NotNull(message = "El tipo de documento no puede estar vacío")
    private TiposDocumento tipoDocumento;

    @ManyToOne
    @NotNull(message = "La forma de pago no puede estar vacía")
    private FormaPago formaPago;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaMovimiento;
    private Long monto;
    private Estado estado;

    public void remove() {
        setEstado(Estado.INACTIVO);
    }

    public Long getId() {
        return id;
    }

    public Boolean getEstaActivo() {
        return estado == Estado.ACTIVO;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoMovimiento() {
        return noMovimiento;
    }

    public void setNoMovimiento(String noMovimiento) {
        this.noMovimiento = noMovimiento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ServicioFacturable getServicio() {
        return servicio;
    }

    public void setServicio(ServicioFacturable servicio) {
        this.servicio = servicio;
    }

    public TiposDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TiposDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public LocalDateTime getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(LocalDateTime fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
