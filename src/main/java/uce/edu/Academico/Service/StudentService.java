package uce.edu.Academico.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uce.edu.Academico.Model.Student;
import uce.edu.Academico.Repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    // Responds with 404 if the student does not exist (it used to throw a RuntimeException and return 500)
    public Student getStudentByEnrollmentNumber(long enrollmentNumber) {
        return studentRepository.findById(enrollmentNumber)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with enrollment number: " + enrollmentNumber));
    }

    // Checks that the student exists before deleting, so a 404 is returned if it does not
    public void deleteStudentByEnrollmentNumber(long enrollmentNumber) {
        getStudentByEnrollmentNumber(enrollmentNumber);
        studentRepository.deleteById(enrollmentNumber);
    }
}
