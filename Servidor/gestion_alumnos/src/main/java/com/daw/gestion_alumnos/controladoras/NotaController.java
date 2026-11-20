package com.daw.gestion_alumnos.controladoras;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.gestion_alumnos.modelos.Alumno;
import com.daw.gestion_alumnos.modelos.Nota;
import com.daw.gestion_alumnos.servicios.AlumnoService;
import com.daw.gestion_alumnos.servicios.NotaService;

@Controller
@RequestMapping("/nota")
public class NotaController {

    private final NotaService notaService;
    private final AlumnoService alumnoService;

    public NotaController(NotaService notaService, AlumnoService alumnoService) {
        this.notaService = notaService;
        this.alumnoService = alumnoService;
    }

    // Mostrar formulario de nueva nota para el alumno {id}
    @GetMapping("/nueva/{id}")
    public String nuevaNota(@PathVariable Long id, Model modelo) {
        Optional<Alumno> alumnoOpt = this.alumnoService.buscarPorId(id);

        if (alumnoOpt.isEmpty()) {
            return "redirect:/alumno";
        }

        Nota nota = new Nota();
        nota.setAlumno(alumnoOpt.get());

        modelo.addAttribute("nota", nota);
        modelo.addAttribute("id_alumno", id);

        return "form_nota";
    }

    // Guardar nota vinculada al alumno
    @PostMapping("/guardar")
    public String guardarNota(@ModelAttribute Nota nota,
                              @RequestParam("id_alumno") Long idAlumno) {
        Optional<Alumno> alumnoOpt = this.alumnoService.buscarPorId(idAlumno);

        if (alumnoOpt.isEmpty()) {
            return "redirect:/alumno";
        }

        nota.setAlumno(alumnoOpt.get());
        this.notaService.guardar(nota);

        return "redirect:/alumno/" + idAlumno;
    }
}