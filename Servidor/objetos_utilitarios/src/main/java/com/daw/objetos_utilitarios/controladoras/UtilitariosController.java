package com.daw.objetos_utilitarios.controladoras;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UtilitariosController {

    @GetMapping("/utilitarios")
    public String mostrar(Model modelo) {
        
        LocalDateTime fecha = LocalDateTime.of(2006, 10, 18, 9, 30);
        modelo.addAttribute("fecha", fecha);
        return "utilitarios";
    }
    
    @GetMapping("/numeros")
    public String numeros(Model modelo) {
        
        modelo.addAttribute("numero", 100.543210);
        return "numeros";
    }

    @GetMapping("/listas")
    public String listas(Model modelo) {
        
        modelo.addAttribute("lista_numeros", List.of(1, 2, 7, 23, 98, 0));
        modelo.addAttribute("lista_nombres", List.of("Pepe", "Juan", "Ana", "María"));
        return "listas";
    }

}
