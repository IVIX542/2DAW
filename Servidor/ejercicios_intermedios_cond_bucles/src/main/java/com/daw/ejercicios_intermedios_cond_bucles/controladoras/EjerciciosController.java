package com.daw.ejercicios_intermedios_cond_bucles.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EjerciciosController {

    @GetMapping("/")
    public String getInicio() {
        return "index";
    }
    
    @GetMapping("/ejercicio1")
    public String getEjercicio1(Model modelo) {

        Usuario lista_usuarios[] = {
            new Usuario("Iván", "ADMIN", false),
            new Usuario("Paco", "USER", true),
            new Usuario("Carlos", "USER", false),
            new Usuario("Germán", "ADMIN", true)
        };

        modelo.addAttribute("lista_usuarios", lista_usuarios);

        return "ej1";
    }
    @GetMapping("/ejercicio2")
    public String getEjercicio2() {
        return "ej2";
    }
    @GetMapping("/ejercicio3")
    public String getEjercicio3() {
        return "ej3";
    }
    @GetMapping("/ejercicio4")
    public String getEjercicio4() {
        return "ej4";
    }
    @GetMapping("/ejercicio5")
    public String getEjercicio5() {
        return "ej5";
    }

}
