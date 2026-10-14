package com.daw.anotaciones.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AnotacionesController {

    @GetMapping("/")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/dato")
    public String recibirDatoGet(
        @RequestParam String nombre, @RequestParam Integer edad,
        Model modelo) {
        modelo.addAttribute("nom", nombre);
        modelo.addAttribute("edad", edad);
        System.out.println("Nombre -----------> " + nombre);
        System.out.println("Edad   -----------> " + edad);
        return "dato";
    }
    
    @GetMapping("/formulario")
    public String recibirFormularioGet() {
        return "formulario";
    }
    
    
    @GetMapping ("/formularioPost")
    public String recibirFormularioPost() {
        return "formularioPost";
    }
    
    @PostMapping("/datoPost")
    public String recibirDatoPost(
        @RequestParam String nombre, @RequestParam Integer edad,
        Model modelo) {
        modelo.addAttribute("nom", nombre);
        modelo.addAttribute("edad", edad);
        System.out.println("Nombre -----------> " + nombre);
        System.out.println("Edad   -----------> " + edad);
        return "dato";
    }
    
    @GetMapping("/producto/{id}")
    public String descripcionProducto(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("ident", id);
        return "producto";
    }
    
    
}
