package com.daw.ejercicios_operaciones_th.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class Operaciones {

    @GetMapping ("/ejercicio1")
    public String ejercicio1(Model modelo){
        modelo.addAttribute("precio", 25);
        modelo.addAttribute("cantidad", 4);


        return "ejercicio1";
    }

    @GetMapping("/ejercicio2")
    public String ejercicio2(Model modelo){
        modelo.addAttribute("edad", 20);
        
        return "ejercicio2";
    }

    @GetMapping("/ejercicio3")
    public String ejercicio3(Model modelo){
        modelo.addAttribute("precio", 15);
        modelo.addAttribute("cantidad", 3);
        modelo.addAttribute("descuento", 5);
        
        return "ejercicio3";
    }

    @GetMapping("/ejercicio4")
    public String ejercicio4(Model modelo){
        modelo.addAttribute("edad", 19);
        modelo.addAttribute("tienePermiso", true);
        
        return "ejercicio4";
    }

    @GetMapping("/ejercicio5")
    public String ejercicio5(Model modelo){
        modelo.addAttribute("nota1", 7);
        modelo.addAttribute("nota2", 5);
        modelo.addAttribute("nota3", 8);
        
        return "ejercicio5";
    }

}
