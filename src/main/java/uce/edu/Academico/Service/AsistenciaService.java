package uce.edu.Academico.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.Academico.Model.Asistencia;
import uce.edu.Academico.Repository.AsistenciaRepository;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    public Asistencia insertarAsistencia(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    public List<Asistencia> listarAsistencias() {
        return asistenciaRepository.findAll();
    }
}
