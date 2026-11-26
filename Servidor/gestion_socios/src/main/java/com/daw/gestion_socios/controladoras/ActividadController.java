package com.daw.gestion_socios.controladoras;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.gestion_socios.modelos.Actividad;
import com.daw.gestion_socios.modelos.Socio;
import com.daw.gestion_socios.servicios.ActividadService;
import com.daw.gestion_socios.servicios.SocioService;

@Controller
@RequestMapping("/actividad")
public class ActividadController {

    private final ActividadService actividadService;
    private final SocioService socioService;

    public ActividadController(ActividadService actividadService, SocioService socioService) {
        this.actividadService = actividadService;
        this.socioService = socioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("actividades", actividadService.listarTodas());
        model.addAttribute("socios", socioService.listarTodos());
        return "list_actividades";
    }

    @GetMapping("/nuevo")
    public String nueva(Model model) {
        model.addAttribute("actividad", new Actividad());
        return "form_actividades";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Actividad> actividad = actividadService.buscarPorId(id);
        if (actividad.isEmpty()) {
            return "redirect:/actividad";
        }
        model.addAttribute("actividad", actividad.get());
        return "form_actividades";
    }

    @PostMapping("/guardar")
    public String guardar(Actividad actividad) {
        actividadService.guardar(actividad);
        return "redirect:/actividad";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        Optional<Actividad> actividadEncontrada = actividadService.buscarPorId(id);
        if (actividadEncontrada.isEmpty()) {
            return "redirect:/actividad";
        }
        Actividad actividad = actividadEncontrada.get();
        if (!actividad.getSocios().isEmpty()) {
            return "redirect:/actividad?error=participantes";
        }
        actividadService.eliminar(id);
        return "redirect:/actividad";
    }

    @PostMapping("/inscribir/{actividadId}")
    public String inscribir(
            @PathVariable Long actividadId,
            @RequestParam Long socioId) {
        Optional<Actividad> actividadEncontrada = actividadService.buscarPorId(actividadId);
        Optional<Socio> socioEncontrado = socioService.buscarPorId(socioId);
        if (actividadEncontrada.isEmpty() || socioEncontrado.isEmpty()) {
            return "redirect:/actividad";
        }
        Actividad actividad = actividadEncontrada.get();
        Socio socio = socioEncontrado.get();
        if (socio.getActividades().add(actividad)) {
            socioService.guardar(socio);
        }
        return "redirect:/actividad";
    }

    @PostMapping("/retirar/{actividadId}/{socioId}")
    public String retirar(
            @PathVariable Long actividadId,
            @PathVariable Long socioId) {
        Optional<Actividad> actividadEncontrada = actividadService.buscarPorId(actividadId);
        Optional<Socio> socioEncontrado = socioService.buscarPorId(socioId);
        if (actividadEncontrada.isEmpty() || socioEncontrado.isEmpty()) {
            return "redirect:/actividad";
        }
        Actividad actividad = actividadEncontrada.get();
        Socio socio = socioEncontrado.get();
        if (socio.getActividades().remove(actividad)) {
            socioService.guardar(socio);
        }
        return "redirect:/actividad";
    }
}
