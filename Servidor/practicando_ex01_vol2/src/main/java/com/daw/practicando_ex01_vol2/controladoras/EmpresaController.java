package com.daw.practicando_ex01_vol2.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EmpresaController {

    @GetMapping("/dashboard")
    public String getDashboard() {
        return "dashboard";
    }
    

}
