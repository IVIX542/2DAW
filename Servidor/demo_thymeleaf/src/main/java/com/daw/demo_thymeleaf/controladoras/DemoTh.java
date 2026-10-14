package com.daw.demo_thymeleaf.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller // Anotar la clase como controladore
public class DemoTh {

    @GetMapping // End point "/"
    public String ejemplo1() {
        return "inicio"; // Template (plantilla) con la vista
    }
    
    @GetMapping("/inicio2") // El end point es "/inicio2"
    public String inicio2(){
        return "inicio2";
    }
    
}
