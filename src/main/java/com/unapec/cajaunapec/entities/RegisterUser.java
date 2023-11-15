package com.unapec.cajaunapec.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class RegisterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede estar vacío")
    @NotEmpty(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String name;

    @NotNull(message = "La dirección no puede estar vacía")
    @NotEmpty(message = "La dirección no puede estar vacía")
    @Size( max = 255, message = "La dirección debe tener 255 caracteres o menos")
    private String address;

    @NotNull(message = "El nombre de usuario no puede estar vacío")
    @NotEmpty(message = "El nombre de usuario no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre de usuario debe tener entre 3 y 50 caracteres")
    private String username;

    @NotNull(message = "La contraseña no puede estar vacía")
    @NotEmpty(message = "La contraseña no puede estar vacía")
    @Size(min = 8, max = 16, message = "La contraseña debe tener entre 8 y 16 caracteres")
    private String password;

    @NotNull(message = "El teléfono no puede estar vacío")
    @NotEmpty(message = "El teléfono no puede estar vacío")
    @Size(min = 10, max = 10, message = "El teléfono debe tener 10 caracteres")
    private String phone;

    @NotNull(message = "El rol no puede estar vacío")
    @NotEmpty(message = "El rol no puede estar vacío")
    private String role;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
