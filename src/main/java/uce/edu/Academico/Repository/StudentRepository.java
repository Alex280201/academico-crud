package uce.edu.Academico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uce.edu.Academico.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
