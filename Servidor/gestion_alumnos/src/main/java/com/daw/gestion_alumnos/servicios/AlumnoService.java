package com.daw.gestion_alumnos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.daw.gestion_alumnos.modelos.Alumno;
import com.daw.gestion_alumnos.modelos.AlumnoRepository;

@Service
public class AlumnoService {

    // inyecta la clase repositorio del alumno
    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository){
        this.alumnoRepository=alumnoRepository;
    }

    // metodos CRUD

    // todos los alumnos
    public List<Alumno> listarTodos(){
        return this.alumnoRepository.findAll();
    }

    public Optional<Alumno> buscarPorId(Long id){
        return this.alumnoRepository.findById(id);
    }

    public Alumno guardar(Alumno alumno){
        return this.alumnoRepository.save(alumno);
    }

    public void eliminar(Long id){
        this.alumnoRepository.deleteById(id);
    }
}
