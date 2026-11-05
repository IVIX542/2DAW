package com.daw.crud_socios.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daw.crud_socios.modelos.Socio;
import com.daw.crud_socios.modelos.SocioRepository;

@Service
public class SocioService {

    /* Inyección automática del repositorio */
    private final SocioRepository socioRepository;

    /* Constructor para la inyección de dependencias */
    public SocioService(SocioRepository socioRepository) {
        this.socioRepository = socioRepository;
    }


    /* MÉTODOS CRUD */

    /* Obtenemos todos los socios de la BD */
    public List<Socio> listarSocios() {
        return socioRepository.findAll();
    }

    /* Buscamos un socio por su ID */
    public Optional<Socio> buscarPorId(Long id) {
        return socioRepository.findById(id);
    }

    /* Guardamos (insertar o actualizar) un socio */
    public Socio guardar(Socio socio) {
        return socioRepository.save(socio);
    }

    /* Eliminamos un socio por ID */
    public void eliminar(Long id) {
        socioRepository.deleteById(id);
    }

    
    /* MÉTODOS PERSONALIZADOS */
    
    /* Socios con nombre especificado */
    public List<Socio> buscarPorNombre(String nombre) {
        return socioRepository.findByNombre(nombre);
    }

    /* Socios con teléfono especificado */
    public List<Socio> buscarPorTelefono(String telefono) {
        return socioRepository.findByTelefono(telefono);
    }

    /* Buscamos los socios con la cuota pagada */
    public List<Socio> buscarCuotaPagada() {
        return socioRepository.findByCuotaPagada(true);
    }
    
}
