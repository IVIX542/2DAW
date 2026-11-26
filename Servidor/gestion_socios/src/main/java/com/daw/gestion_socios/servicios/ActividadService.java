package com.daw.gestion_socios.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daw.gestion_socios.modelos.Actividad;
import com.daw.gestion_socios.repositorios.ActividadRepository;

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public List<Actividad> listarTodas() {
        return actividadRepository.findAll();
    }

    public Optional<Actividad> buscarPorId(Long id) {
        return actividadRepository.findById(id);
    }

    public Actividad guardar(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public void eliminar(Long id) {
        actividadRepository.deleteById(id);
    }
}
