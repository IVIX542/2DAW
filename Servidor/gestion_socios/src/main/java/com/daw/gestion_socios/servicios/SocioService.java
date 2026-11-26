package com.daw.gestion_socios.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daw.gestion_socios.modelos.Socio;
import com.daw.gestion_socios.repositorios.SocioRepository;

@Service
public class SocioService {

    private final SocioRepository socioRepository;

    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }

    public List<Socio> listarTodos() {
        return socioRepository.findAll();
    }

    public Optional<Socio> buscarPorId(Long id) {
        return socioRepository.findById(id);
    }

    public Socio guardar(Socio socio) {
        return socioRepository.save(socio);
    }

    public void eliminar(Long id) {
        socioRepository.deleteById(id);
    }
}
