package com.daw.crud_socios.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping ("/socios") // Ruta por defecto
public class SocioController {

    @GetMapping("") // Ruta sin barra (/entidad)
    public String getInicio() {
        return "inicio";
    }

    @GetMapping("/nuevo")
    public String getNuevoSocio() {
        return "inicio";
    }

    @GetMapping("/guardar")
    public String getGuardarSocio() {
        return "inicio";
    }

    @GetMapping("/editar/{id}")
    public String getEditarSocio() {
        return "inicio";
    }

    @GetMapping("/eliminar/{id}")
    public String getEliminarSocio() {
        return "inicio";
    }

}
