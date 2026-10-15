
package uce.edu.Academico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uce.edu.Academico.Model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}
