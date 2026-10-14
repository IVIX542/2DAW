package com.daw.condicionales_y_bucles.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PruebaCondBuclesController {

    @GetMapping("/ifbasico")
    public String ifbasico(Model modelo) {

        modelo.addAttribute("edad", 27);
        return "condicionales";
    }
    
    @GetMapping("/switchbasico")
    public String switchbasico(Model modelo) {

        modelo.addAttribute("rol", "ADMIN");
        return "condicionales";
    }
    
    @GetMapping("/condrapidos")
    public String condrapidos(Model modelo) {
        
        modelo.addAttribute("edad", 35);
        modelo.addAttribute("persona1", new Persona("Pepe", 54));
        modelo.addAttribute("persona2", null);
        return "condicionales";
    }
    
    @GetMapping("/buclebasico")
    public String buclebasico(Model modelo) {
    
        modelo.addAttribute("lista_numeros", new int[]{345, 12, 895});
        return "bucles";
    }
}
