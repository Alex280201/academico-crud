package uce.edu.Academico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uce.edu.Academico.Model.Attendance;

public interface AttendanceRepository
        extends JpaRepository<Attendance, Long> {
}
