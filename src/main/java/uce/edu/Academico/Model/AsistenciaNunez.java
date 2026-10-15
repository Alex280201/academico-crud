package uce.edu.Academico.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="asistencia")
public class AsistenciaNunez {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numAsistencia;

    private String estado;
    private LocalDate fechAsistencia;

    @ManyToOne
    @JoinColumn(name = "num_matricula")
    private Estudiante estudiante;

    public Long getNumAsistencia() {
        return numAsistencia;
    }

    public void setNumAsistencia(Long numAsistencia) {
        this.numAsistencia = numAsistencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechAsistencia() {
        return fechAsistencia;
    }

    public void setFechAsistencia(LocalDate fechAsistencia) {
        this.fechAsistencia = fechAsistencia;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
}
