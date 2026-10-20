package com.daw.var_frag_bloques.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class FragmentosController {

    @GetMapping("/")
    public String inicio() {
        return "inicio";
    }
    @GetMapping("/productos")
    public String productos() {
        return "productos";
    }
    

}
