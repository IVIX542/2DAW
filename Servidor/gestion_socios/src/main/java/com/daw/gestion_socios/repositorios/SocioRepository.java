package com.daw.gestion_socios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.gestion_socios.modelos.Socio;

public interface SocioRepository extends JpaRepository<Socio, Long>{

}
