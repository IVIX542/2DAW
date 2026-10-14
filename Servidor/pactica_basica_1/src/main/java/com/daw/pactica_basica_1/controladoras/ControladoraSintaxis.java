package com.daw.pactica_basica_1.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daw.pactica_basica_1.Alumno;
import com.daw.pactica_basica_1.Producto;


@Controller 
public class ControladoraSintaxis {

    @GetMapping("/ejercicio1")
    public String getMethodName(Model modelo) {
        
        modelo.addAttribute("nombre", "<strong>Ivan</strong>");
        modelo.addAttribute("edad", "19");

        return "ejercicio1";
    }
    
    @GetMapping("/ejercicio2")
    public String ejercicio2(Model modelo) {
        
        Alumno a = new Alumno("Ivan", "Lopez Benitez", 19);

        modelo.addAttribute("alumno", a); // Añadimos un objeto al modelo

        return "ejercicio2";
    }

    @GetMapping("/producto")
    public String producto(Model modelo) {

        Producto p = new Producto("teclado", 25.5);
        
        modelo.addAttribute("producto", p);

        return "producto";
    }

    @GetMapping("/ejercicio3")
    public String ejercicio3(Model modelo) {

        modelo.addAttribute("nombre", "Ivan");
        modelo.addAttribute("edad", "19");

        return "ejercicio3";
    }
    
}
