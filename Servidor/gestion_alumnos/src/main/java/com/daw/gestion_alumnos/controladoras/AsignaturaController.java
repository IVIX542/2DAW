package com.daw.gestion_alumnos.controladoras;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.gestion_alumnos.modelos.Asignatura;
import com.daw.gestion_alumnos.servicios.AsignaturaService;

@Controller
@RequestMapping("/asignatura")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    // Listar todas las asignaturas
    @GetMapping
    public String listarAsignaturas(Model modelo) {
        modelo.addAttribute("listaAsignaturas", this.asignaturaService.listarTodas());
        return "lista_asignaturas";
    }

    // Formulario para crear una asignatura
    @GetMapping("/nueva")
    public String nuevaAsignatura(Model modelo) {
        modelo.addAttribute("asignatura", new Asignatura());
        return "form_asignatura";
    }

    // Guardar asignatura (nueva o editada)
    @PostMapping("/guardar")
    public String guardarAsignatura(@ModelAttribute Asignatura asignatura) {
        this.asignaturaService.guardar(asignatura);
        return "redirect:/asignatura";
    }

    // Formulario para editar una asignatura
    @GetMapping("/editar/{id}")
    public String editarAsignatura(@PathVariable Long id, Model modelo) {
        Optional<Asignatura> asignaturaOpt = this.asignaturaService.buscarPorId(id);

        if (asignaturaOpt.isEmpty()) {
            return "redirect:/asignatura";
        }

        modelo.addAttribute("asignatura", asignaturaOpt.get());
        return "form_asignatura";
    }

    // Eliminar asignatura
    @GetMapping("/eliminar/{id}")
    public String eliminarAsignatura(@PathVariable Long id) {
        Optional<Asignatura> asignaturaOpt = this.asignaturaService.buscarPorId(id);

        if (asignaturaOpt.isEmpty()) {
            return "redirect:/asignatura";
        }

        this.asignaturaService.eliminar(id);
        return "redirect:/asignatura";
    }
}