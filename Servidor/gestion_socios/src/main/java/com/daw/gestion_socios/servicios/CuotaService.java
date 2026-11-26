package com.daw.gestion_socios.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daw.gestion_socios.modelos.Cuota;
import com.daw.gestion_socios.repositorios.CuotaRepository;

@Service
public class CuotaService {

    private final CuotaRepository cuotaRepository;

    public CuotaService(CuotaRepository cuotaRepository) {
        this.cuotaRepository = cuotaRepository;
    }

    public List<Cuota> listarTodas() {
        return cuotaRepository.findAll();
    }

    public Optional<Cuota> buscarPorId(Long id) {
        return cuotaRepository.findById(id);
    }

    public Cuota guardar(Cuota cuota) {
        return cuotaRepository.save(cuota);
    }

    public void eliminar(Long id) {
        cuotaRepository.deleteById(id);
    }
}
