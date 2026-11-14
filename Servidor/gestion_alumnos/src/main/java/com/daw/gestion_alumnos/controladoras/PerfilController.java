package com.daw.gestion_alumnos.controladoras;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.gestion_alumnos.modelos.Alumno;
import com.daw.gestion_alumnos.modelos.Perfil;
import com.daw.gestion_alumnos.servicios.AlumnoService;
import com.daw.gestion_alumnos.servicios.PerfilService;


@Controller 
@RequestMapping ("/alumno/perfil")
public class PerfilController {

    private final PerfilService perfilService;
    private final AlumnoService alumnoService;

    public PerfilController(PerfilService perfilService, AlumnoService alumnoService) {
        this.perfilService = perfilService;
        this.alumnoService = alumnoService;
    }

    /* PERFIL */

    // Obtener perfil de un alumno mediante su id
    @GetMapping("/{id}")
    public String verPerfil(@PathVariable Long id, Model modelo) {
        Optional<Alumno> alumno = this.alumnoService.buscarPorId(id);

        // Si no hay un alumno con ese id
        if (alumno.isEmpty() || alumno.get().getPerfil() == null) {
            return "redirect:/alumno";
        }

        // el alumno con ese id existe, lo añadimos al modelo
        modelo.addAttribute("alumno", alumno.get());

        return "perfil_alumno";
    }

    // Nuevo perfil
    @GetMapping("/nuevo")
    public String nuevoPerfil(@RequestParam(required = false) Long id_alumno, Model modelo) {
        Perfil perfil = new Perfil();

        modelo.addAttribute("perfil", perfil);
        modelo.addAttribute("id_alumno", id_alumno);

        if(id_alumno == null) {
            modelo.addAttribute("alumnos", alumnoService.listarTodos());
        }

        return "form_perfil";
    }

    // Guardar perfil
    @GetMapping("/guardar")
    public String guardarPerfil(@ModelAttribute Perfil perfil) {
        this.perfilService.guardar(perfil);

        return "redirect:/alumno";
    }

    // Modificar perfil

    
    // Eliminar perfil de un alumno mediante su id
    

}
