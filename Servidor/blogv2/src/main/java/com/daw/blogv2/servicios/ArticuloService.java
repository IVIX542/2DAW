package com.daw.blogv2.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daw.blogv2.modelos.Articulo;
import com.daw.blogv2.modelos.ArticuloRepository;

/**
 * Capa de servicio que actúa como intermediaria entre el controlador
 * y el repositorio. Aquí se aplicaría la lógica de negocio si fuera necesaria.
 */
@Service
public class ArticuloService {

    // Inyección automática del repositorio (Spring lo gestiona).
    private final ArticuloRepository articuloRepository;

    // Constructor para inyección de dependencias.
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    // ============================
    // Métodos CRUD
    // ============================

    /** Obtiene todos los artículos de la base de datos. */
    public List<Articulo> listarTodos() {
        return articuloRepository.findAll();
    }

    /** Busca un artículo por su ID. */
    public Optional<Articulo> buscarPorId(Long id) {
        return articuloRepository.findById(id);
    }

    /** Guarda (inserta o actualiza) un artículo. */
    public Articulo guardar(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    /** Elimina un artículo por su ID. */
    public void eliminar(Long id) {
        articuloRepository.deleteById(id);
    }

    // ============================
    // Métodos personalizados
    // ============================

    /** Devuelve los artículos de un autor específico. */
    public List<Articulo> buscarPorAutor(String autor) {
        return articuloRepository.findByAutor(autor);
    }

    /** Devuelve los artículos según su estado de publicación. */
    public List<Articulo> buscarPorPublicado(boolean publicado) {
        return articuloRepository.findByPublicado(publicado);
    }

    /** Busca artículos que contengan una palabra en el título. */
    public List<Articulo> buscarPorPalabraClave(String palabra) {
        return articuloRepository.findByTituloContainingIgnoreCase(palabra);
    }
}

