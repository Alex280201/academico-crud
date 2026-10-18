package uce.edu.Academico.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uce.edu.Academico.Model.Asistencia;
import uce.edu.Academico.Model.Estudiante;
import uce.edu.Academico.Service.AsistenciaService;
import uce.edu.Academico.Service.EstudianteService;

@Controller
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("mostrarFormNuevaAsistencia/{numMat}")
    public String mostrarFormNuevaAsistencia(
            @PathVariable(value = "numMat") long numMat, Model model) {

        Estudiante estudiante = estudianteService.getEstudiantePorNumMatri(numMat);
        Asistencia asistencia = new Asistencia();
        asistencia.setEstudiante(estudiante);

        model.addAttribute("asistencia", asistencia);
        return "nueva_asistencia";
    }

    @PostMapping("grabarAsistencia")
    public String grabarAsistencia(
            @ModelAttribute("asistencia") Asistencia asistencia) {

        asistenciaService.insertarAsistencia(asistencia);
        return "/index";
    }

    @GetMapping("listarAsistencias")
    public String listarAsistencias(Model model) {
        model.addAttribute("listaAsistencias", asistenciaService.listarAsistencias());
        return "listar_asistencias";
    }
}


   
