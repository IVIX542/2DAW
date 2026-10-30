package com.daw.blogv2.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/**
 * Clase de entidad que representa la tabla 'articulos' en la base de datos.
 * Cada instancia de esta clase corresponde a una fila de la tabla.
 */
@Entity                         // Marca la clase como una entidad JPA.
@Table(name = "articulos")      // Indica el nombre exacto de la tabla en la base de datos.
public class Articulo {

    // ============================
    // Atributos (columnas)
    // ============================

    /**
     * Campo 'id' -> Clave primaria, generada automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Equivale a AUTO_INCREMENT en MySQL.
    private Long id;

    /**
     * Campo 'titulo' -> Título del artículo.
     */
    @Column(nullable = false, length = 200)
    private String titulo;

    /**
     * Campo 'contenido' -> Texto completo del artículo.
     * Se marca como @Lob (Large Object) para permitir textos largos.
     */
    @Lob
    @Column(nullable = false)
    private String contenido;

    /**
     * Campo 'autor' -> Nombre del autor que escribió el artículo.
     */
    @Column(nullable = false, length = 100)
    private String autor;

    /**
     * Campo 'fecha_publicacion' -> Fecha en que se publicó el artículo.
     * Se mapea con LocalDate para trabajar con fechas sin horas.
     */
    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDate fechaPublicacion;

    /**
     * Campo 'publicado' -> Indica si el artículo está visible o en borrador.
     */
    @Column(nullable = false)
    private boolean publicado;

    // ============================
    // Constructores
    // ============================

    /** Constructor vacío obligatorio para JPA. */
    public Articulo() {
    }

    /** Constructor con parámetros para crear instancias fácilmente. */
    public Articulo(String titulo, String contenido, String autor, LocalDate fechaPublicacion, boolean publicado) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.publicado = publicado;
    }

    // ============================
    // Métodos getter y setter
    // ============================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    // ============================
    // Método toString (para depuración)
    // ============================

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", publicado=" + publicado +
                '}';
    }
}
