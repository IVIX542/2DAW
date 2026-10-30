package com.daw.blogv2.modelos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de repositorio para la entidad Articulo.
 * 
 * Spring Data JPA creará automáticamente la implementación en tiempo de ejecución.
 * 
 * Hereda de JpaRepository, que ya proporciona métodos CRUD básicos:
 * - findAll() -> devuelve todos los artículos
 * - findById(id) -> busca un artículo por su id
 * - save(obj) -> inserta o actualiza un artículo
 * - deleteById(id) -> elimina un artículo
 */
@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    // ============================
    // Consultas personalizadas
    // ============================

    /**
     * Encuentra todos los artículos de un autor concreto.
     * El nombre del método sigue la convención de Spring Data JPA.
     */
    List<Articulo> findByAutor(String autor);

    /**
     * Devuelve los artículos que estén publicados (true) o no (false).
     */
    List<Articulo> findByPublicado(boolean publicado);

    /**
     * Busca artículos cuyo título contenga una palabra clave (ignorando mayúsculas/minúsculas).
     */
    List<Articulo> findByTituloContainingIgnoreCase(String palabraClave);
}

