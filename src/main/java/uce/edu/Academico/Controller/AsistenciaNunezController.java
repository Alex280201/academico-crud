package uce.edu.Academico.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uce.edu.Academico.Model.AsistenciaNunez;
import uce.edu.Academico.Model.Estudiante;
import uce.edu.Academico.Service.AsistenciaNunezService;
import uce.edu.Academico.Service.EstudianteService;

@Controller
public class AsistenciaNunezController {

    @Autowired
    private AsistenciaNunezService asistenciaService;

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("mostrarFormNuevaAsistencia/{numMat}")
    public String mostrarFormNuevaAsistencia(
            @PathVariable(value = "numMat") long numMat, Model model) {

        Estudiante estudiante = estudianteService.getEstudiantePorNumMatri(numMat);
        AsistenciaNunez asistencia = new AsistenciaNunez();
        asistencia.setEstudiante(estudiante);

        model.addAttribute("asistencia", asistencia);
        return "nueva_asistencia";
    }

    @PostMapping("grabarAsistencia")
    public String grabarAsistencia(
            @ModelAttribute("asistencia") AsistenciaNunez asistencia) {

        asistenciaService.insertarAsistencia(asistencia);
        return "/index";
    }

    @GetMapping("listarAsistencias")
    public String listarAsistencias(Model model) {
        model.addAttribute("listaAsistencias", asistenciaService.listarAsistencias());
        return "listar_asistencias";
    }
}


   
