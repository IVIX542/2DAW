package com.daw.crud_socios.controladoras;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.crud_socios.modelos.Socio;
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

    @GetMapping("/{id}")
    public String getSocioPorId(@PathVariable Long id, Model modelo) {
        Optional<Socio> socio = socioService.buscarPorId(id);

        modelo.addAttribute("socio", socio.get());

        return "detalle-socio";
    }

    @GetMapping("/nuevo")
    public String getNuevoSocio() {
        return "form-socios";
    }
    
    @GetMapping("/editar/{id}")
    public String getEditarSocio(@PathVariable Long id, Model modelo) {
        Optional<Socio> socio = socioService.buscarPorId(id);

        modelo.addAttribute("socio", socio.get());

        return "form-socios";
    }
    
    @GetMapping("/guardar")
    public String getGuardarSocio() {
        return "inicio";
    }

    @GetMapping("/eliminar/{id}")
    public String getEliminarSocio() {
        return "inicio";
    }

}
