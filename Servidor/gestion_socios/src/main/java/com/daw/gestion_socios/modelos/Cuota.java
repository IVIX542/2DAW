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


    /* GETTERS Y SETTERS */

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public LocalDate getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
}
