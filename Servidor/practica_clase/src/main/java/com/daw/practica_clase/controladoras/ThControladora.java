package com.daw.practica_clase.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daw.practica_clase.Producto;

@Controller 
public class ThControladora {

    @GetMapping("/producto")
    public String producto(Model modelo){
        Producto p = new Producto(
            "Monitor", 189.95, 12,
            "Informática"
        );

        modelo.addAttribute("producto", p);

        return "producto";
    }

}
