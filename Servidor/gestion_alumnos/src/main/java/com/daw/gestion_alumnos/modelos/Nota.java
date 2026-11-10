package com.daw.gestion_alumnos.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "notas")
public class Nota {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id_nota;

    private String asignatura; 
    private double calificacion;

    /* Relación muchos a uno: muchas notas pertenece a un alumno */
    @ManyToOne
    @JoinColumn(name = "id_alumno") // Clave foránea en la tabla notas
    private Alumno alumno;

    public Nota() {}

    public Nota(String asignatura, double calificacion, Alumno alumno) {
        this.asignatura = asignatura;
        this.calificacion = calificacion;
        this.alumno = alumno;
    }

    /* GETTERS Y SETTERS */

    public Long getId_nota() {
        return id_nota;
    }

    public void setId_nota(Long id_nota) {
        this.id_nota = id_nota;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    
}
