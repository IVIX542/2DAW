package com.daw.pruebas;

public class Producto {
    public String nombre;
    public Double precio;
    public Integer stock;
    public String categoria;

    public Producto (
        String nombre, Double precio, Integer stock, String categoria
    ){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    @Override 
    public String toString(){
        return "Producto: " + nombre
                + ", Precio: " + precio + "€"
                + ", Stock: " + stock + " unidades"
                + ", Categoría: " + categoria;
    }

}
