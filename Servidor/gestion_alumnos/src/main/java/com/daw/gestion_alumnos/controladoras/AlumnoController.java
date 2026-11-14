package com.daw.gestion_alumnos.controladoras;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.gestion_alumnos.modelos.Alumno;
import com.daw.gestion_alumnos.modelos.Nota;
import com.daw.gestion_alumnos.modelos.Perfil;
import com.daw.gestion_alumnos.servicios.AlumnoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller 
@RequestMapping ("/alumno")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    /* EndPoints */

    // Listar todos los alumnos
    @GetMapping
    public String listarAlumnos(Model modelo) {

        modelo.addAttribute("listaAlumnos", this.alumnoService.listarTodos());

        return "lista_alumnos";
    }

    // Detalle alumno
    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id, Model modelo) {
        Optional<Alumno> alumno = this.alumnoService.buscarPorId(id);

        if (alumno.isEmpty()) {
            return "redirect:/alumno";
        }

        modelo.addAttribute("alumno", alumno.get());

        return "detalle_alumno";
    }

    @GetMapping("/perfil/{id}")
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
    
    @GetMapping ("/perfil/eliminar/{id}")
    public String eliminarPerfil(@PathVariable Long id, Model modelo) {
        Optional<Alumno> alumno = this.alumnoService.buscarPorId(id);

        alumnoService.eliminar(alumno.get().getId_alumno());

        return "redirect:/alumno";
    }

    /* Pruebas */
    // De prueba
    @GetMapping("/crea_alumno")
    public String prueba() {

        Alumno alumno1 = new Alumno("Iván", "López Benítez");

        this.alumnoService.guardar(alumno1);

        return "probando";
    }
    
    @GetMapping("/crea_alumno_con_notas")
    public String pruebaConNotas() {
        Alumno alumno2 = new Alumno("Ángel", "Benito Camelo");

        Nota nota1 = new Nota("Servidor", 0, alumno2);
        Nota nota2 = new Nota("Cliente", 1, alumno2);

        alumno2.setNotas(List.of(nota1, nota2));

        this.alumnoService.guardar(alumno2);

        return "alumno_con_notas";
    }

    @GetMapping("/crea_alumno_con_perfil")
    public String pruebaPerfil() {

        Alumno alumno1 = new Alumno("Pepe Bueno", "Perez Perez");

        Perfil pl1 = new Perfil("Calle Principal", "666 666 666", "foto-perfil.jpg");

        alumno1.setPerfil(pl1);

        this.alumnoService.guardar(alumno1);

        return "probando";
    }

    @GetMapping("/crea_alumno_con_perfil_y_notas")
    public String pruebaPerfilyNotas() {

        Alumno alumno1 = new Alumno("Ivan", "Lopez Benitez");

        Nota nota1 = new Nota("Servidor", 0, alumno1);
        Nota nota2 = new Nota("Cliente", 1, alumno1);

        alumno1.setNotas(List.of(nota1, nota2));

        Perfil pl1 = new Perfil("Calle Estrecha", "666 536 072", "foto-perfil.jpg");

        alumno1.setPerfil(pl1);

        this.alumnoService.guardar(alumno1);

        return "probando";
    }
    

}
