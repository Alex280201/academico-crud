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
import uce.edu.Academico.Model.Student;
import uce.edu.Academico.Service.StudentService;

/**
 * REST API for the Student CRUD.
 *
 *   GET    /api/students        -> lists all students
 *   GET    /api/students/{id}   -> one student by enrollment number (404 if it does not exist)
 *   POST   /api/students        -> creates a student (400 if the data is not valid)
 *   PUT    /api/students/{id}   -> updates a student (404 / 400)
 *   DELETE /api/students/{id}   -> deletes a student (404 if it does not exist)
 */
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> list() {
        return studentService.listStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getStudentByEnrollmentNumber(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody Student student) {
        student.setEnrollmentNumber(null); // the database generates the enrollment number
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @Valid @RequestBody Student student) {
        studentService.getStudentByEnrollmentNumber(id); // throws 404 if it does not exist
        student.setEnrollmentNumber(id);
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.deleteStudentByEnrollmentNumber(id);
    }
}
