package uce.edu.Academico.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numMatricula;

    @NotBlank(message = "La cédula es obligatoria")
    private String numCedula;

    @NotBlank(message = "El nombre es obligatorio")
    private String nomEstudiante;

    @Email(message = "El email no es válido")
    private String email;

    private String telefono;
    private String direccion;
    private LocalDate fechNacimiento;

    @JsonIgnore
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<AsistenciaNunez> asistencias;

    public Long getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(Long numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public String getNomEstudiante() {
        return nomEstudiante;
    }

    public void setNomEstudiante(String nomEstudiante) {
        this.nomEstudiante = nomEstudiante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechNacimiento() {
        return fechNacimiento;
    }

    public void setFechNacimiento(LocalDate fechNacimiento) {
        this.fechNacimiento = fechNacimiento;
    }

    public List<AsistenciaNunez> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<AsistenciaNunez> asistencias) {
        this.asistencias = asistencias;
    }
}