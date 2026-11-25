package com.daw.gestion_socios.modelos;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "socios")
public class Socio {

    @OneToMany (mappedBy = "socio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cuota> cuotas;

    @OneToOne (mappedBy = "socio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Carnet carnet;

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 100)
    private String nombre;
    
    @Column (nullable = false, length = 100)
    private String apellidos;

    @Column (nullable = false, length = 10, unique = true)
    private String dni;

    @Column (length = 15)
    private String telefono;

    @Column (length = 100)
    private String email;

    @Column (nullable = false)
    private LocalDate fecha_alta;

    /* CONSTRUCTORES */
    public Socio(List<Cuota> cuotas, Carnet carnet, Long id, String nombre, String apellidos, String dni,
            String telefono, String email, LocalDate fecha_alta) {
        this.cuotas = cuotas;
        this.carnet = carnet;
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fecha_alta = fecha_alta;
    }

    public Socio() {
    }
    
    /* GETTERS Y SETTERS */

    public List<Cuota> getCuotas() {
        return cuotas;
    }


    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(LocalDate fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    
}
