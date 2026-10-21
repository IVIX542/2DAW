package com.daw.ejercicios_avanzados_condiciones_bucles.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  
public class Controladora {

    @GetMapping("/")
    public String getInicio() {
        return "inicio";
    }

    @GetMapping("/pedidos")
    public String getPedidos(Model modelo) {
        Pedido pedidos[] = {
            new Pedido(1, "pendiente"),
            new Pedido(2, "enviado"),
            new Pedido(3, "entregado")
        };

        Cliente cliente1 = new Cliente("Iván", "ADMIN", pedidos);

        modelo.addAttribute("cliente1", cliente1);


        return "pedidos";
    }
    

}
