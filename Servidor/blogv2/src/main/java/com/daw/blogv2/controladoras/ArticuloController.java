package com.daw.blogv2.controladoras;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daw.blogv2.modelos.Articulo;
import com.daw.blogv2.servicios.ArticuloService;

/**
 * Controlador MVC (no REST) que maneja las peticiones y devuelve vistas Thymeleaf.
 * Se apoya en ArticuloService para la lógica de negocio y acceso a datos.
 */
@Controller
@RequestMapping("/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    // ============================
    // Mostrar todos los artículos
    // ============================
    @GetMapping
    public String listarArticulos(Model model) {
        model.addAttribute("listaArticulos", articuloService.listarTodos());
        return "lista-articulos"; // plantilla Thymeleaf: lista-articulos.html
    }

    // ============================
    // Mostrar formulario para crear nuevo artículo
    // ============================
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("articulo", new Articulo());
        return "form-articulo"; // plantilla: form-articulo.html
    }

    // ============================
    // Guardar nuevo artículo
    // ============================
    @PostMapping("/guardar")
    public String guardarArticulo(@ModelAttribute("articulo") Articulo articulo) {
        // Si no se ha especificado fecha, la ponemos automáticamente
        if (articulo.getFechaPublicacion() == null) {
            articulo.setFechaPublicacion(LocalDate.now());
        }
        articuloService.guardar(articulo);
        return "redirect:/articulos";
    }

    // ============================
    // Mostrar formulario de edición
    // ============================
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Articulo articulo = articuloService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de artículo no válido: " + id));
        model.addAttribute("articulo", articulo);
        return "form-articulo"; // reutiliza la misma plantilla de formulario
    }

    // ============================
    // Eliminar artículo
    // ============================
    @GetMapping("/eliminar/{id}")
    public String eliminarArticulo(@PathVariable Long id) {
        articuloService.eliminar(id);
        return "redirect:/articulos";
    }

    // ============================
    // Ver detalle de un artículo
    // ============================
    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        Optional<Articulo> articulo = articuloService.buscarPorId(id);
        if(articulo.isEmpty()){
            return "redirect:/articulos";
        }        
        model.addAttribute("articulo", articulo.get());
        return "detalle-articulo"; // plantilla: detalle-articulo.html
    }

}

