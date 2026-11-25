package com.daw.gestion_socios.modelos;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table (name = "socios")
public class Socio {

    @OneToMany (mappedBy = "socio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cuota> cuotas;

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 100)
    private String nombre;
    
    @Column (nullable = false, length = 100)
    private String apellidos;

    @Column (nullable = false, length = 10, unique = true)
    private String dni;

    @Column (length = 15)
    private String telefono;

    @Column (length = 100)
    private String email;

    @Column (nullable = false)
    private LocalDate fecha_alta;

}
