package com.daw.crud_socios.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Clase como entidad JPA
@Table (name="socios") // Nombre de la tabla en la BD
public class Socio {
    /* ATRIBUTOS Ó COLUMNAS */

    /* Campo ID - Clave primaria */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) // AUTO_ICNREMENT
    private Long id;

    /* Nombre - Varchar(100) */
    @Column(nullable = false, length = 100)
    private String nombre;

    /* Apellidos - Varchar(100) */
    @Column(nullable = false, length = 100)
    private String apellidos;

    /* DNI - Varchar(10) FK */
    @Column(name = "dni", nullable = false, length = 10)
    private String dni;

    /* Telefono - Varchar(15) */
    @Column(length = 15)
    private String telefono;

    /* Email - Varchar(100) */
    @Column (length = 100)
    private String email;

    /* Cuota Pagada - Boolean (0-1) */
    @Column ( columnDefinition = "boolean default 0")
    private boolean cuotaPagada = false;

    /* Fecha de Alta - Date */
    @Column (nullable = false)
    private LocalDate fechaAlta;


    /* CONSTRUCTORES */
    
    /* Constructor vacío */
    public Socio() {}

    /* Constructor con parámetros */
    public Socio(Long id, String nombre, String apellidos, String dni, String telefono, String email, boolean cuotaPagada, LocalDate fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.cuotaPagada = cuotaPagada;
        this.fechaAlta = fechaAlta;
    }
    

    /* GETTERS Y SETTERS - generados automáticamente*/
    
    /* id */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /* nombre */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* apellidos */
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /* dni */
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    /* telefono */
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /* email */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* cuotaPagada */
    public boolean isCuotaPagada() {
        return cuotaPagada;
    }

    public void setCuotaPagada(boolean cuotaPagada) {
        this.cuotaPagada = cuotaPagada;
    }

    /* fechaAlta */
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /* TOSTRING - generado automáticamente */
    @Override
    public String toString() {
        return "Socio [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", telefono="
                + telefono + ", email=" + email + ", cuotaPagada=" + cuotaPagada + ", fechaAlta=" + fechaAlta + "]";
    }
    
}
