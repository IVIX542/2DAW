package com.daw.practicando_ex01_vol2.controladoras;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EmpresaController {

    @GetMapping("/dashboard")
    public String getDashboard(Model modelo) {
        Map<String,String> empleadosRoles = Map.of(
            "Carlos", "Desarrollador", "Laura", "Diseñadora", "Marcos", "Proyect Manager"
        );

        modelo.addAttribute("empleadosRoles", empleadosRoles);

        return "dashboard";
    }
    

}
