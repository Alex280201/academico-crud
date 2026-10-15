package uce.edu.Academico.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uce.edu.Academico.Model.Estudiante;
import uce.edu.Academico.Repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public Estudiante insertarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> listarEstudiante() {
        return estudianteRepository.findAll();
    }

    // Si no existe, responde 404 (antes lanzaba RuntimeException y daba 500)
    public Estudiante getEstudiantePorNumMatri(long numMatricula) {
        return estudianteRepository.findById(numMatricula)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Estudiante no encontrado con matrícula: " + numMatricula));
    }

    // Verifica que exista antes de borrar, para devolver 404 si no está
    public void eliminarEstPorNumMatri(long numMat) {
        getEstudiantePorNumMatri(numMat);
        estudianteRepository.deleteById(numMat);
    }
}