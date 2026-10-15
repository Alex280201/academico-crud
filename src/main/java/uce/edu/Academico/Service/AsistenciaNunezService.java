package uce.edu.Academico.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.Academico.Model.AsistenciaNunez;
import uce.edu.Academico.Repository.AsistenciaNunezRepository;

@Service
public class AsistenciaNunezService {

    @Autowired
    private AsistenciaNunezRepository asistenciaRepository;

    public AsistenciaNunez insertarAsistencia(AsistenciaNunez asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    public List<AsistenciaNunez> listarAsistencias() {
        return asistenciaRepository.findAll();
    }
}
