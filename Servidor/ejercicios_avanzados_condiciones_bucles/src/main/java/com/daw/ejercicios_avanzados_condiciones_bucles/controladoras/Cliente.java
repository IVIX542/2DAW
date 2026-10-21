package com.daw.ejercicios_avanzados_condiciones_bucles.controladoras;

public class Cliente {
    public String nombre;
    public String rol;
    public Pedido pedidos[];

    public Cliente(String nombre, String rol, Pedido pedidos[]) {
        this.nombre = nombre;
        this.rol = rol;
        this.pedidos = pedidos;
    }
}
