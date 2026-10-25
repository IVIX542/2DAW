package com.daw.practicando_ex01.controladoras;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PerfilController {

    @GetMapping("/perfil")
    public String getPerfil(Model modelo) {
        String usuario = "AnaGomez";
        Double saldo = 1250.75;
        boolean esVip = true;
        List<String> aficiones = List.of("Leer", "Jugar", "Comprar");
        
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("saldo", saldo);
        modelo.addAttribute("esVip", esVip);
        modelo.addAttribute("aficiones", aficiones);

        return "perfil";
    }
    

}
