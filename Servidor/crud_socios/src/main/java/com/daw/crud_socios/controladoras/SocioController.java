package com.daw.crud_socios.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.crud_socios.servicios.SocioService;

@Controller 
@RequestMapping ("/socios") // Ruta por defecto
public class SocioController {

    /* Inyección automática del servicio */
    private final SocioService socioService;

    /* Constructor para la inyección de dependencias */
    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @GetMapping("") // Ruta sin barra (/socios)
    public String getInicio(Model modelo) {
        modelo.addAttribute("listaSocios", socioService.listarSocios());

        return "lista-socios";
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
