package com.daw.calculadora_web.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller 
public class CalculadoraController {

    @GetMapping("/")
    public String getMethodName() {
        return "formulario";
    }
    
    @GetMapping("/resultado")
    public String getMethodName(Model modelo,
        @RequestParam String operacion,
        @RequestParam(defaultValue = "0.0") Double num1, @RequestParam(defaultValue = "0.0") Double num2) {

        Double resultado = 0.0; 
        switch(operacion.toLowerCase()){
            case "suma":
                resultado = num1 + num2;
                break;
            case "resta":
                resultado = num1 - num2;
                break;
            case "mult":
                resultado = num1 * num2;
                break;
            case "div":
                resultado = num1 / num2;
                break;
            default:
                resultado = -1.0;
        }

        modelo.addAttribute("resultado", resultado);

        return "resultado";
    }
    

}
