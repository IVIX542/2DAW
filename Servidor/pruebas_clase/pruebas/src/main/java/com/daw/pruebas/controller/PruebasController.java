package com.daw.pruebas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daw.pruebas.Producto;


@Controller 
public class PruebasController {
    @GetMapping("/")
    public String getMethodName(Model modelo) {
        
        Producto p = new Producto("Teclado", 15.5, 200, "Informática");
        modelo.addAttribute("producto", p);

        return "index";
    }
    
}
