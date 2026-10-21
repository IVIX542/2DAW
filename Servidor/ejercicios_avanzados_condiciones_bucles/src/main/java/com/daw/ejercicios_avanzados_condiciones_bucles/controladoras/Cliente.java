package com.daw.ejercicios_avanzados_condiciones_bucles.controladoras;

public class Cliente {
    public String nombre;
    public Pedido pedidos[];

    public Cliente(String nombre, Pedido pedidos[]) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }
}
