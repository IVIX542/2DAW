package com.daw.gestion_socios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.gestion_socios.modelos.Carnet;

public interface CarnetRepository extends JpaRepository<Carnet, Long> {

}
