package com.daw.ejercicios_avanzados_condiciones_bucles.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  
public class Controladora {

    @GetMapping("/")
    public String getMethodName() {
        return "inicio";
    }
    

}
