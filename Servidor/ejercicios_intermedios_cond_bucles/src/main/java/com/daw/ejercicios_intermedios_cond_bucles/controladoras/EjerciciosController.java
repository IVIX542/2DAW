package com.daw.ejercicios_intermedios_cond_bucles.controladoras;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EjerciciosController {

    @GetMapping("/")
    public String getInicio() {
        return "index";
    }
    
    @GetMapping("/ejercicio1")
    public String getEjercicio1(Model modelo) {

        Usuario lista_usuarios[] = {
            new Usuario("Iván", "ADMIN", false),
            new Usuario("Paco", "USER", true),
            new Usuario("Carlos", "USER", false),
            new Usuario("Germán", "ADMIN", true)
        };

        modelo.addAttribute("lista_usuarios", lista_usuarios);

        return "ej1";
    }
    @GetMapping("/ejercicio2")
    public String getEjercicio2(Model modelo) {
        Map<String, List<String>> categoriasMap = new HashMap<>();

        categoriasMap.put("Frutas", List.of("Manzana", "Naranja"));
        categoriasMap.put("Electrónica", List.of("Portátil", "Móvil"));
        categoriasMap.put("Categoría sin cosas", null);

        modelo.addAttribute("categorias", categoriasMap);

        return "ej2";
    }
    @GetMapping("/ejercicio3")
    public String getEjercicio3() {
        return "ej3";
    }
    @GetMapping("/ejercicio4")
    public String getEjercicio4() {
        return "ej4";
    }
    @GetMapping("/ejercicio5")
    public String getEjercicio5() {
        return "ej5";
    }

}
