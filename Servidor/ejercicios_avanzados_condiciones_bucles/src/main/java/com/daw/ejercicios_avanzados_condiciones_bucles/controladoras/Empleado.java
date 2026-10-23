package com.daw.ejercicios_avanzados_condiciones_bucles.controladoras;

public class Empleado {
    
    private int numero;
    private String nombre;
    private String departamento;
    private double salario;

    // Constructor vacío
    public Empleado() {
    }

    // Constructor con parámetros
    public Empleado(int numero, String nombre, String departamento, double salario) {
        this.numero = numero;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
