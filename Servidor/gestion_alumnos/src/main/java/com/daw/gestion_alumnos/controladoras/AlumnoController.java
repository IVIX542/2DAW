package com.daw.gestion_alumnos.controladoras;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.daw.gestion_alumnos.modelos.Alumno;
import com.daw.gestion_alumnos.modelos.Perfil;
import com.daw.gestion_alumnos.servicios.AlumnoService;
import com.daw.gestion_alumnos.servicios.PerfilService;

import com.daw.gestion_alumnos.modelos.Asignatura;
import com.daw.gestion_alumnos.modelos.Nota;
import com.daw.gestion_alumnos.servicios.AsignaturaService;

@Controller 
@RequestMapping ("/alumno")
public class AlumnoController {

    private final AlumnoService alumnoService;
    private final PerfilService perfilService;
    private final AsignaturaService asignaturaService;

    public AlumnoController(AlumnoService alumnoService,
        AsignaturaService asignaturaService,
        PerfilService perfilService) {
        this.alumnoService = alumnoService;
        this.asignaturaService = asignaturaService;
        this.perfilService = perfilService;
    }

    /* EndPoints */

    /* ALUMNO */

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

    // Nuevo alumno
    @GetMapping ("/nuevo") 
    public String nuevoAlumno(Model modelo) {
        // Creamos un alumno vacío
        Alumno alumno = new Alumno();

        // Lo añadimos al modelo
        modelo.addAttribute("alumno", alumno);

        // Devolvemos el formulario
        return "form_alumno";
    }

    // Guardar alumno
    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute Alumno alumno) {
        this.alumnoService.guardar(alumno);
        
        return "redirect:/alumno";
    }
    
    // Editar alumno
    @GetMapping ("/editar/{id}")
    public String editarAlumno(@PathVariable Long id, Model modelo) {
        Optional<Alumno> alumno = this.alumnoService.buscarPorId(id);

        if(alumno.isEmpty()) {
            return "redirect:/alumno";
        }

        modelo.addAttribute("alumno", alumno.get());

        return "form_alumno";
    }

    // Eliminar alumno mediante su id
    @GetMapping ("/eliminar/{id}")
    // NOTE: usar @PathVariable, ya que es obligatoria
    public String eliminarAlumno(@PathVariable Long id, Model modelo) {
        Optional<Alumno> alumno = this.alumnoService.buscarPorId(id);

        if (alumno.isEmpty()) {
            return "redirect:/alumno";
        }

        alumnoService.eliminar(alumno.get().getId_alumno());

        return "redirect:/alumno";
    }

    // Listado de matrivulas de un alumno
    @GetMapping ("/matriculas/{id}") 
    public String verMatriculas(@PathVariable Long id, Model modelo) {

        Optional<Alumno> alumno = this.alumnoService.buscarPorId(id);
        
        if (alumno.isEmpty()) {
            return "redirect:/alumno";
        }

        alumnoService.buscarPorId(id);

        modelo.addAttribute("alumno", alumno.get());

        return "matriculas_alumnos";
    }

    /* PERFIL */

    // Obtener perfil de un alumno mediante su id
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

    // Nuevo perfil
    @GetMapping("/perfil/nuevo")
    public String nuevoPerfil(@RequestParam(required = false) Long id_alumno, Model modelo) {
        // Sin alumno asociado no se puede crear el perfil
        if (id_alumno == null) {
            return "redirect:/alumno";
        }

        Perfil perfil = new Perfil();

        modelo.addAttribute("perfil", perfil);
        modelo.addAttribute("id_alumno", id_alumno);

        return "form_perfil";
    }

    // Guardar perfil (crear o modificar)
    @PostMapping("/perfil/guardar")
    public String guardarPerfil(@ModelAttribute Perfil perfil,
        @RequestParam("id_alumno") Long id_alumno
    ) {
        Optional<Alumno> alumnoOpt = this.alumnoService.buscarPorId(id_alumno);

        if (alumnoOpt.isEmpty()) {
            return "redirect:/alumno";
        }

        Alumno alumno = alumnoOpt.get();
        Perfil perfilActual = alumno.getPerfil();

        if (perfilActual == null) {
            // Perfil nuevo: lo asignamos al alumno
            alumno.setPerfil(perfil);
        } else {
            // Perfil existente: conservamos su id para actualizarlo
            perfil.setId_perfil(perfilActual.getId_perfil());
            perfil.setAlumno(alumno);
        }

        // El perfil es el lado propietario de la relación, lo guardamos
        this.perfilService.guardar(perfil);

        return "redirect:/alumno/perfil/" + id_alumno;
    }

    // Modificar perfil
    @GetMapping("/perfil/editar/{id}")
    public String editarPerfil(@PathVariable Long id, Model modelo) {
        Optional<Alumno> alumno = this.alumnoService.buscarPorId(id);

        if (alumno.isEmpty() || alumno.get().getPerfil() == null) {
            return "redirect:/alumno";
        }

        modelo.addAttribute("perfil", alumno.get().getPerfil());
        modelo.addAttribute("id_alumno", id);

        return "form_perfil";
    }

    // Eliminar perfil de un alumno mediante su id
    @GetMapping("/perfil/eliminar/{id}")
    public String eliminarPerfil(@PathVariable Long id) {
        Optional<Alumno> alumnoOpt = this.alumnoService.buscarPorId(id);

        if (alumnoOpt.isEmpty() || alumnoOpt.get().getPerfil() == null) {
            return "redirect:/alumno";
        }

        // Creamos un alumno y un perfil
        Alumno alumno = alumnoOpt.get();
        Perfil perfil = alumno.getPerfil();

        // Desvinculamos ambos lados de la relación
        alumno.setPerfil(null);
        perfil.setAlumno(null);

        // Guardamos el alumno para actualizar la referencia y borramos el perfil
        this.alumnoService.guardar(alumno);
        this.perfilService.eliminar(perfil.getId_perfil());

        return "redirect:/alumno/";
    }

    /* MATRÍCULA */
    // Mostrar formulario para matricular a un alumno en una asignatura
    @GetMapping("/matricula/nueva/{id}")
    public String nuevaMatricula(@PathVariable Long id, Model modelo) {
        Optional<Alumno> alumnoOpt = this.alumnoService.buscarPorId(id);

        if (alumnoOpt.isEmpty()) {
            return "redirect:/alumno";
        }

        modelo.addAttribute("alumno", alumnoOpt.get());
        modelo.addAttribute("listaAsignaturas", this.asignaturaService.listarTodas());

        return "form_matricula";
    }

    // Guardar la nueva matrícula
    @PostMapping("/matricula/guardar")
    public String guardarMatricula(@RequestParam("id_alumno") Long idAlumno,  @RequestParam("id_asignatura") Long idAsignatura) {
        Optional<Alumno> alumnoOpt = this.alumnoService.buscarPorId(idAlumno);
        Optional<Asignatura> asignaturaOpt = this.asignaturaService.buscarPorId(idAsignatura);

        if (alumnoOpt.isEmpty() || asignaturaOpt.isEmpty()) {
            return "redirect:/alumno";
        }

        Alumno alumno = alumnoOpt.get();
        Asignatura asignatura = asignaturaOpt.get();

        // Reutiliza el método de relación N:N que ya tienes en Alumno
        alumno.matricularEn(asignatura);
        this.alumnoService.guardar(alumno);

        return "redirect:/alumno/matriculas/" + idAlumno;
    }

    // Eliminar (desmatricular) una asignatura de un alumno
    @GetMapping("/matricula/eliminar/{idAlumno}/{idAsignatura}")
    public String eliminarMatricula(@PathVariable Long idAlumno,  @PathVariable Long idAsignatura) {
        Optional<Alumno> alumnoOpt = this.alumnoService.buscarPorId(idAlumno);
        Optional<Asignatura> asignaturaOpt = this.asignaturaService.buscarPorId(idAsignatura);

        if (alumnoOpt.isEmpty() || asignaturaOpt.isEmpty()) {
            return "redirect:/alumno";
        }

        Alumno alumno = alumnoOpt.get();
        Asignatura asignatura = asignaturaOpt.get();

        alumno.desmatricularDe(asignatura);
        this.alumnoService.guardar(alumno);

        return "redirect:/alumno/matriculas/" + idAlumno;
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
    
    @GetMapping("/matricula_alumnos")
    public String matriculaAlumnos() {

        // crear dos alumnos
        Alumno ana = new Alumno("Ana", "García López");
        Alumno juan = new Alumno("Juan", "Martín Ruiz");

        // crear dos asignaturas
        Asignatura mat = new Asignatura("Matemáticas", "1º ESO");
        Asignatura len = new Asignatura("Lengua", "1º ESO");

        // matriculas alumnos en asignaturas
        ana.matricularEn(mat);
        juan.matricularEn(mat);
        ana.matricularEn(len);

        this.asignaturaService.guardar(mat);
        this.asignaturaService.guardar(len);

        this.alumnoService.guardar(juan);
        this.alumnoService.guardar(ana);

        return "probando";
    }

}
