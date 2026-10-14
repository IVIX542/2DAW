/**
 * @author Iván López Benítez
 */

package com.daw.pactica_basica_1.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <-- Importamos la librería Model para poder trabajar con la UI
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladoraTh {

    /* Ruta inicial */
    @GetMapping
    public String inicio() {
        return "index";
    }

    /* Ruta "/sobre" */
    @GetMapping("/sobre")
    public String sobre() {
        return "sobre";
    }

    /* Ruta "/variables" */
    @GetMapping("/variables")
    public String variables(Model model) { // Añadimos Model a los parámetros

        // Utilizamos model.addAttribute(), indicando nombre y descripción de las
        // variables a enviar
        model.addAttribute("titulo", "Información del Curso"); /**
                                                                * Añade al modelo una variable "título" con el contenido
                                                                * "Información del Curso"
                                                                */
        model.addAttribute("descripcion",
                "Esta página muestra atributos enviados desde el controlador de Spring Boot.");

        // Le indica al motor de ThymeLeaf qué plantilla buscar, dentro de "templates"
        return "variables";
    }

    /* Ruta "/tabla" */
    @GetMapping("/tabla")
    public String tabla(Model model) {

        // Enviamos el título y la cabecera al endpoint "/tabla"
        model.addAttribute("titulo", "Listado de Asignaturas");
        model.addAttribute("cabecera", "Asignaturas del trimestre");

        // Creamos un Array con las asignaturas y le añadimos sus objetos
        String[] asignaturas = { "Programación", "Bases de Datos",
                "Entornos de Desarrollo", "Lenguajes de Marcas" };

        // Enviamos el ArrayLis
        model.addAttribute("asignaturas", asignaturas);

        return "tabla";
    }

}
