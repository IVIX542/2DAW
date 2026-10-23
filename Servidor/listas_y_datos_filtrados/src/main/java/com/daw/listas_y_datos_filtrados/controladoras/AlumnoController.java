package com.daw.listas_y_datos_filtrados.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AlumnoController {

    @GetMapping("/alumnos")
    public String getAlumnos(Model modelo) {
        Map<String, Double> notas1 = Map.of("Matemáticas", 8.5, "Lengua", 7.2, "Inglés", 9.0);
        Map<String, Double> notas2 = Map.of("Matemáticas", 4.3, "Lengua", 5.1, "Inglés", 3.8);
        Map<String, Double> notas3 = Map.of("Matemáticas", 9.4, "Lengua", 9.1, "Inglés", 8.7);

        List<Alumno> listaAlumnos = List.of(
            new Alumno("Laura", "Sánchez López", "1º DAW", notas1),
            new Alumno("Carlos", "Martin Pérez", "2º DAM", notas2),
            new Alumno("Ana", "Ruiz Fernández", "1º ASIR", notas3)
        );

        modelo.addAttribute("alumnos", listaAlumnos);

        return "alumnos";
    }
}
