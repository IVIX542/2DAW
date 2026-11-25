package com.daw.gestion_socios.modelos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "carnets")
public class Carnet {

    @OneToOne
    @JoinColumn (name = "socio_id", unique = true)
    private Socio socio;

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 20, unique = true, nullable = false)
    private String numero;

    @Column (nullable = false)
    private LocalDate fecha_emision;

    @Column (nullable = false)
    private LocalDate fecha_caducidad;

}
