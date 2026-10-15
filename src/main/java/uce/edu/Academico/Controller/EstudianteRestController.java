package uce.edu.Academico.Controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import uce.edu.Academico.Model.Estudiante;
import uce.edu.Academico.Service.EstudianteService;

/**
 * API REST del CRUD de Estudiante.
 *
 *   GET    /api/estudiantes        -> lista todos
 *   GET    /api/estudiantes/{id}   -> uno por número de matrícula (404 si no existe)
 *   POST   /api/estudiantes        -> crea (400 si los datos no son válidos)
 *   PUT    /api/estudiantes/{id}   -> actualiza (404 / 400)
 *   DELETE /api/estudiantes/{id}   -> elimina (404 si no existe)
 */
@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "*")
public class EstudianteRestController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> listar() {
        return estudianteService.listarEstudiante();
    }

    @GetMapping("/{id}")
    public Estudiante obtener(@PathVariable Long id) {
        return estudianteService.getEstudiantePorNumMatri(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante crear(@Valid @RequestBody Estudiante estudiante) {
        estudiante.setNumMatricula(null); // la BD genera el número de matrícula
        return estudianteService.insertarEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante actualizar(@PathVariable Long id, @Valid @RequestBody Estudiante estudiante) {
        estudianteService.getEstudiantePorNumMatri(id); // lanza 404 si no existe
        estudiante.setNumMatricula(id);
        return estudianteService.insertarEstudiante(estudiante);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        estudianteService.eliminarEstPorNumMatri(id);
    }
}