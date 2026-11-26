package com.daw.gestion_socios.modelos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany 
    @JoinTable (
        name = "socios_actividades",
        joinColumns = @JoinColumn (name = "socio_id"),
        inverseJoinColumns = @JoinColumn (name = "actividad_id")
    )
    private Set<Actividad> actividades = new HashSet<>();

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long socio_id;

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
    public Socio(List<Cuota> cuotas, Carnet carnet, Long socio_id, String nombre, String apellidos, String dni,
            String telefono, String email, LocalDate fecha_alta) {
        this.cuotas = cuotas;
        this.carnet = carnet;
        this.socio_id = socio_id;
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

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Long getId() {
        return socio_id;
    }

    public void setId(Long socio_id) {
        this.socio_id = socio_id;
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
