package com.daw.prueba1.controller;

import java.time.*;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class comprobacion {
    
    @GetMapping("/comprobar")//Esto es un endpoint (ruta)
    public String comprobar(){
        return "<h1>SpringBoot funciona correctamente</h1>"; //Devuelve código html
    }

    @GetMapping("/hora")
    public String devuelveHora() {
        LocalTime horaLocal = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "<p>Hora actual en el servidor: " + horaLocal.format(formato) + "</p>";
    }
    
}
