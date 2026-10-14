/**
 * @author: Iván López Benítez
 */

package com.daw.pactica_basica_1.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class ControladoraThAmpliacion {

    @GetMapping("/curso/java")
    public String java(Model modelo) {

        String nombre = "Introducción a Java";

        String aula = "Aula 201";

        int p_totales = 25;
        int p_ocupadas = 18;
        int p_disponibles = p_totales - p_ocupadas;

        modelo.addAttribute("nombre_curso", nombre);
        modelo.addAttribute("aula", aula);
        modelo.addAttribute("plazas_totales", p_totales);
        modelo.addAttribute("plazas_ocupadas", p_ocupadas);
        modelo.addAttribute("plazas_disponibles", p_disponibles);
        

        return "curso";
    }

    @GetMapping("/curso/web")
    public String web(Model modelo) {

        String nombre = "Desarrollo Web";

        String aula = "Aula 202";

        int p_totales = 20;
        int p_ocupadas = 20;
        int p_disponibles = p_totales - p_ocupadas;

        modelo.addAttribute("nombre_curso", nombre);
        modelo.addAttribute("aula", aula);
        modelo.addAttribute("plazas_totales", p_totales);
        modelo.addAttribute("plazas_ocupadas", p_ocupadas);
        modelo.addAttribute("plazas_disponibles", p_disponibles);

        return "curso";
    }
    

}
