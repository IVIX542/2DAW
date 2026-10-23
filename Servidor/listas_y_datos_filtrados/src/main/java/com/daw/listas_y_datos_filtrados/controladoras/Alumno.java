package com.daw.listas_y_datos_filtrados.controladoras;

import java.util.Map;

public class Alumno {
    private String nombre;
    private String apellidos;
    private String curso;

    // Map -> Asignatura : nota
    private Map<String, Double> notas;
    private double media;

    // Constructor
    public Alumno(String nombre, String apellidos, String curso, Map<String, Double> notas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.notas = notas;

        // Calculamos la media
        this.media = calcularMedia(notas);
    }

    private double calcularMedia(Map<String, Double> notas) {
        // En caso de null o vacío
        if (notas == null || notas.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;

        for (double nota : notas.values()) {
            suma += nota;
        }

        // Devolvemos la suma de las notas dividida entre el número total de notas
        return suma / notas.size();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCurso() {
        return curso;
    }

    public Map<String, Double> getNotas() {
        return notas;
    }

    public double getMedia() {
        return media;
    }
}
