package com.daw.gestion_alumnos.modelos;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
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

    // Relación N a N: un alumno está matriculado en varias asignaturas
    //                 una asignatura tiene matriculados varios alumnos
    @ManyToMany // por defecto son FetchType.LAZY, no se suele indicar CascadeType.REMOVE
    @JoinTable(
        name = "alumno_asignatura", // tabla intermedia
        joinColumns = @JoinColumn(name = "id_alumno"), // FK a esta entidad
        inverseJoinColumns = @JoinColumn(name = "id_asignatura") // FK a la otra entidad
    )
    private Set<Asignatura> asignaturas = new HashSet<>(); // conjunto de asignaturas en la que está matriculado el alumno
    
    /* Constructor vacío */
    public Alumno() {}

    /* Constructor con parámetros */
    public Alumno(String nombre, String apellidos) { 
        this.nombre = nombre; 
        this.apellidos = apellidos; 
    }

    /* MÉTODOS */
    // Métodos para añadir o eliminar asignaturas
    public void matricularEn(Asignatura asignatura) {
        asignaturas.add(asignatura); // añado la asignatura al conjunto de asignaturas del alumno
        asignatura.getAlumnos().add(this); // añado el alumno al conjunto de alumnos de la asignatura
    }

    public void desmatricularDe(Asignatura asignatura) {
        asignaturas.remove(asignatura); // borro la asignatura del conjunto de asignaturas del alumno
        asignatura.getAlumnos().remove(this); // borro el alumno del conjunto de alumnos de la asignatura
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
        if (perfil != null) {
            perfil.setAlumno(this); // mantenemos sincronía
        }
    }

    public Set<Asignatura> getAsignaturas() { return asignaturas; }



    @Override
    public String toString() {
        return "Alumno [id_alumno=" + id_alumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", notas=" + notas
                + "]";
    }

}
