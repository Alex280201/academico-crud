package uce.edu.Academico.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uce.edu.Academico.Model.Estudiante;
import uce.edu.Academico.Service.EstudianteService;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("listarEstudiantes")
    public String listarEstudiantes(Model model) {
        model.addAttribute("listEstudiantes", estudianteService.listarEstudiante());
        return "listar_estudiantes";
    }
    @GetMapping("mostrarFormNuevoEstudiante")
    public String mostrarFormNuevoEstudiante(Model model) {
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante", estudiante);
        return "nuevo_estudiante";
    }

    @PostMapping("grabarEstudiante")
    public String grabarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        estudianteService.insertarEstudiante(estudiante);
        return "/index";
    }

    @GetMapping("mostrarFormActualizarEst/{numMat}")
    public String mostrarFormActualizarEst(@PathVariable(value = "numMat") long numMat, Model model) {
        Estudiante estudiante = estudianteService.getEstudiantePorNumMatri(numMat);
        model.addAttribute("estudiante", estudiante);
        return "actualizar_estudiante";
    }
    
    @GetMapping("/eliminarEstudiante/{numMat}")
    public String eliminarEstudiante(@PathVariable(value = "numMat") long numMat) {
        estudianteService.eliminarEstPorNumMatri(numMat);
        return "/index";
    }

    
}
