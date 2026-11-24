package com.daw.gestion_socios.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table (name = "cuotas")
public class Cuota {

    /**
     * CAMPOS
    */
    // ID
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    // Año
    @Column (nullable = false)
    private Integer anio;

    // Importe
    @Column (nullable = false)
    private Float importe;

    // Fecha Pago
    @Column
    private LocalDate fecha_pago;


}
