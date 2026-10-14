package com.daw.prueba2.controladoras;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController 
public class MiPrimeraControladora { //Clase controladora

    @GetMapping("/comprobar") //endpoint, o ruta de entrada
    public String comprobar() {

        return "Comprobado."; // respuesta del cliente

    }

    @GetMapping("/")
    public String inicio() {
        return "Estás en la raíz de la aplicación";
    }
    
    @GetMapping("/hora")
    public String hora() { // devuelve la hora del server

        LocalTime hora = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        return new String("Hora del server: " + hora.format(formato));
    }
    

}
