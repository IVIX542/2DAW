package com.daw.gestion_alumnos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daw.gestion_alumnos.modelos.Asignatura;
import com.daw.gestion_alumnos.modelos.AsignaturaRepository;

@Service 
public class AsignaturaService {

    // inyecta la clase repositorio del alumno
    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    // métodos CRUD

    // todas las asignaturas
    public List<Asignatura> listarTodas() {
        return this.asignaturaRepository.findAll();
    }

    public Optional<Asignatura> buscarPorId(Long id) {
        return this.asignaturaRepository.findById(id);
    }

    public Asignatura guardar(Asignatura asignatura) {
        return this.asignaturaRepository.save(asignatura);
    }

    public void eliminar(Long id) {
        this.asignaturaRepository.deleteById(id);
    }

}
