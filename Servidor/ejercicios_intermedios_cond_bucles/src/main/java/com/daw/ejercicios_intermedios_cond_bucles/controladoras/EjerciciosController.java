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
    public String getEjercicio3(Model modelo) {
        String arr_encabezados[] = {"Nº", "Nombre", "Nota", "Resultado"};
        Alumno alumno1 = new Alumno(1, "Ana", 8.5, true);
        Alumno alumno2 = new Alumno(2, "Luis", 4.2, false);

        Alumno arr_alumnos[] = {alumno1, alumno2};

        modelo.addAttribute("encabezados", arr_encabezados);
        modelo.addAttribute("alumnos", arr_alumnos);

        return "ej3";
    }

    @GetMapping("/ejercicio4")
    public String getEjercicio4(Model modelo) {

        String arr_encabezados[]  = {
            "Nombre", "Precio", "Etiqueta"
        };

        Producto arr_productos[] = {
            new Producto("Lapiz", 1.5, 50),
            new Producto("Teclado", 10.5, 100),
            new Producto("Coche", 10000.0, 100),
            new Producto("Altavoz", 50.0, 0)
        };

        modelo.addAttribute("encabezados", arr_encabezados);
        modelo.addAttribute("productos", arr_productos);

        return "ej4";
    }

    @GetMapping("/ejercicio5")
    public String getEjercicio5(Model modelo) {
        Jugador arr_jugadores[] = {
            new Jugador("Juan", 980),
            new Jugador("Ana", 920),
            new Jugador("Mario", 890),
            new Jugador("Luis", 860)
        };

        modelo.addAttribute("jugadores", arr_jugadores);
        
        return "ej5";
    }

}
