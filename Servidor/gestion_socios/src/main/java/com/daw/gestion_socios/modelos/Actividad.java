package com.daw.gestion_socios.modelos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "actividades")
public class Actividad {

    @ManyToMany (mappedBy = "actividades")
    private Set<Socio> socios = new HashSet<>();

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long actividad_id;

    @Column (length = 100, nullable = false)
    private String nombre;

    @Column (length = 255)
    private String descripcion;

    public Actividad() {
    }

    public Long getId() {
        return actividad_id;
    }

    public void setId(Long actividad_id) {
        this.actividad_id = actividad_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Socio> getSocios() {
        return socios;
    }

    public void setSocios(Set<Socio> socios) {
        this.socios = socios;
    }

}
