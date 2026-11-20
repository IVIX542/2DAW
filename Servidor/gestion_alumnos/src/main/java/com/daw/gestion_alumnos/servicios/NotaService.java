package com.daw.gestion_alumnos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daw.gestion_alumnos.modelos.Nota;
import com.daw.gestion_alumnos.modelos.NotaRepository;

@Service
public class NotaService {

    private final NotaRepository notaRepository;

    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    public List<Nota> listarTodas() {
        return this.notaRepository.findAll();
    }

    public Optional<Nota> buscarPorId(Long id) {
        return this.notaRepository.findById(id);
    }

    public Nota guardar(Nota nota) {
        return this.notaRepository.save(nota);
    }

    public void eliminar(Long id) {
        this.notaRepository.deleteById(id);
    }
}