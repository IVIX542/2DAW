package com.daw.gestion_alumnos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daw.gestion_alumnos.modelos.Perfil;
import com.daw.gestion_alumnos.modelos.PerfilRepository;


@Service 
public class PerfilService {

    // Inyectar la clase repositorio del perfil
    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    // Métodos CRUD

    // todos los perfiles
    public List<Perfil> listarTodos(){
        return this.perfilRepository.findAll();
    }

    public Optional<Perfil> buscarPorId(Long id){
        return this.perfilRepository.findById(id);
    }

    public Perfil guardar(Perfil alumno){
        return this.perfilRepository.save(alumno);
    }

    public void eliminar(Long id){
        this.perfilRepository.deleteById(id);
    }

}
