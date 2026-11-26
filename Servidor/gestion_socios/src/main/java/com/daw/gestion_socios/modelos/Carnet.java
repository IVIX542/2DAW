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
    private Long carnet_id;

    @Column (length = 20, unique = true, nullable = false)
    private String numero;

    @Column (nullable = false)
    private LocalDate fecha_emision;

    @Column (nullable = false)
    private LocalDate fecha_caducidad;

    /* CONSTRUCTORES */
    public Carnet() {
    }
    
    public Carnet(Socio socio, Long carnet_id, String numero, LocalDate fecha_emision, LocalDate fecha_caducidad) {
        this.socio = socio;
        this.carnet_id = carnet_id;
        this.numero = numero;
        this.fecha_emision = fecha_emision;
        this.fecha_caducidad = fecha_caducidad;
    }

    /* GETTERS Y SETTERS */

    public Socio getSocio() {
        return socio;
    }


    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Long getId() {
        return carnet_id;
    }

    public void setId(Long carnet_id) {
        this.carnet_id = carnet_id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public LocalDate getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(LocalDate fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }



    
}
