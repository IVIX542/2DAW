package com.daw.ejercicios_avanzados_condiciones_bucles.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  
public class Controladora {

    Pedido pedidos[] = {
        new Pedido("Cajas de cartón", "pendiente", 10.0),
        new Pedido("Metacrilato", "pendiente", 20.2),
        
        new Pedido("Teclados de membrana", "enviado", 30.5),
        new Pedido("Micrófonos", "enviado", 50.99),

        new Pedido("Ratones ópticos", "entregado", 20.45),
        new Pedido("Pegatinas", "entregado", 1.02)
    };
    
    Cliente cliente1 = new Cliente("Iván", "ADMIN", pedidos);

    // Datos necesarios para el Ejercicio 4 (Empleados)
    Empleado empleados[] = {
        new Empleado(1, "Ana Pérez", "Dirección", 2500.0),
        new Empleado(2, "Carlos Gómez", "Ventas", 1500.0),
        new Empleado(3, "Lucía Martín", "Dirección", 2200.0),
        new Empleado(4, "David Ruiz", "Almacén", 1200.0)
    };

    @GetMapping("/")
    public String getInicio(Model modelo) {
        modelo.addAttribute("cliente1", cliente1);
        return "inicio"; // Ejercicio 1
    }

    @GetMapping("/pedidos")
    public String getPedidos(Model modelo) {
        modelo.addAttribute("cliente1", cliente1);
        return "pedidos"; // Ejercicio 2
    }

    @GetMapping("/catalogo")
    public String getCatalogo(Model modelo) {
        modelo.addAttribute("cliente1", cliente1);
        modelo.addAttribute("filtro", "todos"); // oferta, caro, todos
        return "catalogo"; // Ejercicio 3
    }
    
    @GetMapping("/empleados")
    public String getEmpleados(Model modelo) {
        modelo.addAttribute("cliente1", cliente1);
        modelo.addAttribute("empleados", empleados);
        return "empleados"; // Ejercicio 4
    }

    @GetMapping("/panel")
    public String getPanel(Model modelo) {
        modelo.addAttribute("cliente1", cliente1);
        // Inicializamos las variables booleanas para evitar errores de tipo null en el Ejercicio 5
        modelo.addAttribute("mostrarPerfil", true);
        modelo.addAttribute("mostrarPedidos", true);
        modelo.addAttribute("mostrarMensajes", false);
        return "panel"; // Ejercicio 5
    }
}