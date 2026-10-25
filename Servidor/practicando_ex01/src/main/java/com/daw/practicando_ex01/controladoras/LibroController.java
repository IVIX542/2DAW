package com.daw.practicando_ex01.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

// NOTE: faltaba
@RequestMapping ("/biblioteca") // Ruta base

public class LibroController {

    @GetMapping("/buscar")
    public String getBuscar(Model modelo, @RequestParam String titulo) {

        modelo.addAttribute("titulo", titulo);

        return "resultado-libro";
    }

    @GetMapping("/detalle/{isbn}")
    public String getMethodName(Model modelo, @PathVariable Long isbn) {

        modelo.addAttribute("codigoIsbn", isbn);

        return "detalle-libro";
    }
    
    
    
}
