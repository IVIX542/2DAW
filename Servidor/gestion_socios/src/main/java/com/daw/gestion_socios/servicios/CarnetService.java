package com.daw.gestion_socios.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daw.gestion_socios.modelos.Carnet;
import com.daw.gestion_socios.repositorios.CarnetRepository;

@Service
public class CarnetService {

    private final CarnetRepository carnetRepository;

    public CarnetService(CarnetRepository carnetRepository) {
        this.carnetRepository = carnetRepository;
    }

    public List<Carnet> listarTodos() {
        return carnetRepository.findAll();
    }

    public Optional<Carnet> buscarPorId(Long id) {
        return carnetRepository.findById(id);
    }

    public Carnet guardar(Carnet carnet) {
        return carnetRepository.save(carnet);
    }

    public void eliminar(Long id) {
        carnetRepository.deleteById(id);
    }
}
