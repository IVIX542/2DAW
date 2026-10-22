package com.daw.ejercicios_avanzados_condiciones_bucles.controladoras;

public class Pedido {
    public Integer id;
    public String nombre;
    public String estado;

    public Pedido(Integer id, String nombre, String estado){
        this.nombre = nombre;
        this.id = id;
        this.estado = estado;
    }
}
