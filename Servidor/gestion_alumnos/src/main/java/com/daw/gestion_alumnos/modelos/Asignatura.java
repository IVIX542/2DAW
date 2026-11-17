package com.daw.gestion_alumnos.modelos;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "asignaturas")
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignatura;

    private String nombre;
    private String curso;

    // Parte de la relación N a N
    @ManyToMany(mappedBy = "asignaturas")
    private Set<Alumno> alumnos = new HashSet<>();

    // Constructor vacío
    public Asignatura() {}

    // Constructor completo
    public Asignatura(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    // Getters y setters
    public Long getId_asignatura() { return id_asignatura; }
    public String getNombre() { return nombre; }
    public String getCurso() { return curso; }
    public Set<Alumno> getAlumnos() { return alumnos; }


}
