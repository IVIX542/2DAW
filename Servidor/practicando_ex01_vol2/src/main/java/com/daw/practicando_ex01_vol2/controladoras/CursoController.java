package com.daw.practicando_ex01_vol2.controladoras;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/* Bloque 1 */

@Controller

@RequestMapping("/academico") // Ruta base
public class CursoController {

    @GetMapping("/filtrar")
    public String getFiltrar(Model modelo, @RequestParam String nivel) {
        modelo.addAttribute("nivelFiltro", nivel);
        
        return "lista-cursos";
    }
    
    @GetMapping("/curso/{codigo}/modulo/{idModulo}")
    public String getMethodName(
        Model modelo,
        @PathVariable String codigo,
        @PathVariable int idModulo) 
    {
        modelo.addAttribute("codigo", codigo);
        modelo.addAttribute("idModulo", idModulo);

        return "detalle-modulo";
    }

}
