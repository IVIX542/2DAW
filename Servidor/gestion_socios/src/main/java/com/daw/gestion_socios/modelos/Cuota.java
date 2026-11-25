package com.daw.gestion_socios.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "cuotas")
public class Cuota {

    /**
     * RELACIONES
    */

    // Relación N a 0
    @ManyToOne
    @JoinColumn (name = "socio_id", unique = true) // Clave foránea
    private Socio socio;

    /**
     * CAMPOS
    */
    // ID
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    // Año
    @Column (nullable = false, unique = true)
    private Integer anio;

    // Importe
    @Column (nullable = false)
    private Float importe;

    // Fecha Pago
    @Column
    private LocalDate fecha_pago;

}
