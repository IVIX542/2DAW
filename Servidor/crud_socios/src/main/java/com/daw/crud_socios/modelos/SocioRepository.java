package com.daw.crud_socios.modelos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Socio: Clase o entidad de la BD con la que vamos a trabajar
 * Long: Tipo de dato de la clave primaria
 */
public interface SocioRepository extends JpaRepository<Socio, Long> {

    /* Búsqueda por nombre */
    List<Socio> findByNombre (String nombre);
    
    /* Búsqueda por teléfono */
    List<Socio> findByTelefono(String telefono);
    
    /* Búsqueda por cuota pagada (0 ó 1) */
    List<Socio> findByCuotaPagada(boolean cuotaPagada);

}
