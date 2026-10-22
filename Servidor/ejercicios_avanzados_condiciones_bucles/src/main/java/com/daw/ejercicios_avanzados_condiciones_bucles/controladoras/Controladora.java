package com.daw.ejercicios_avanzados_condiciones_bucles.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  
public class Controladora {

    Pedido pedidos[] = {
        new Pedido(1, "Cajas de cartón", "pendiente"),
        new Pedido(2, "Teclados de membrana", "enviado"),
        new Pedido(3, "Ratones ópticos", "entregado")
    };
    Cliente cliente1 = new Cliente("Iván", "ADMIN", pedidos);

    @GetMapping("/")
    public String getInicio(Model modelo) {
        modelo.addAttribute("cliente1", cliente1);
        
        return "inicio";
    }

    @GetMapping("/pedidos")
    public String getPedidos(Model modelo) {
        modelo.addAttribute("cliente1", cliente1);


        return "pedidos";
    }
    

}
