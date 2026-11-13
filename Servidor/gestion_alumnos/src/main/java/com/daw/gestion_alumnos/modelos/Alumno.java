package com.daw.gestion_alumnos.modelos;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "alumnos")
public class Alumno {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alumno;

    private String nombre;
    private String apellidos;

    /* Relación uno a muchos: un alumno tiene muchas notas
       mappedBy hace referencia al atributo de la clase relacionada */
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Nota> notas;
    
    // Relación uno a uno: un alumno tiene un perfil
    @OneToOne(mappedBy = "alumno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Perfil perfil;
    
    /* Constructor vacío */
    public Alumno() {}

    /* Constructor con parámetros */
    public Alumno(String nombre, String apellidos) { 
        this.nombre = nombre; 
        this.apellidos = apellidos; 
    }

    /* GETTERS Y SETTERS */
    public Long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
        this.id_alumno = id_alumno;
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

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public Perfil getPerfil() { return perfil; }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
        perfil.setAlumno(this); // mantenemos sincronía
    }



    @Override
    public String toString() {
        return "Alumno [id_alumno=" + id_alumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", notas=" + notas
                + "]";
    }

}
