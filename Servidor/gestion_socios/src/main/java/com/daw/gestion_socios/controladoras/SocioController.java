package com.daw.gestion_socios.controladoras;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.gestion_socios.modelos.Socio;
import com.daw.gestion_socios.servicios.SocioService;

@Controller
@RequestMapping("/socio")
public class SocioController {

    private final SocioService socioService;

    public SocioController(SocioService socioService) {
        this.socioService = socioService;
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("socios", socioService.listarTodos());
        return "list_socios";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("socio", new Socio());
        return "form_socios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Socio> socio = socioService.buscarPorId(id);
        if (socio.isEmpty()) {
            return "redirect:/socio";
        }
        model.addAttribute("socio", socio.get());
        return "form_socios";
    }

    @GetMapping("/{id}")
    public String ficha(@PathVariable Long id, Model model) {
        Optional<Socio> socio = socioService.buscarPorId(id);
        if (socio.isEmpty()) {
            return "redirect:/socio";
        }
        model.addAttribute("socio", socio.get());
        return "ficha_socio";
    }

    @PostMapping("/guardar")
    public String guardar(Socio socio) {
        boolean dniRepetido = false;
        List<Socio> socios = socioService.listarTodos();
        for (Socio socioGuardado : socios) {
            if (socioGuardado.getDni().equalsIgnoreCase(socio.getDni())
                    && (socio.getId() == null || !socioGuardado.getId().equals(socio.getId()))) {
                dniRepetido = true;
                break;
            }
        }

        if (dniRepetido) {
            if (socio.getId() == null) {
                return "redirect:/socio/nuevo?error=dni";
            }
            return "redirect:/socio/editar/" + socio.getId() + "?error=dni";
        }

        socioService.guardar(socio);
        return "redirect:/socio";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        Optional<Socio> socioEncontrado = socioService.buscarPorId(id);
        if (socioEncontrado.isEmpty()) {
            return "redirect:/socio";
        }
        Socio socio = socioEncontrado.get();
        boolean tieneCuotas = false;
        if (socio.getCuotas() != null && !socio.getCuotas().isEmpty()) {
            tieneCuotas = true;
        }

        boolean tieneActividades = !socio.getActividades().isEmpty();
        if (tieneCuotas || socio.getCarnet() != null || tieneActividades) {
            return "redirect:/socio?error=relaciones";
        }

        socioService.eliminar(id);
        return "redirect:/socio";
    }
}
