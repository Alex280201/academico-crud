package uce.edu.Academico.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uce.edu.Academico.Model.Student;
import uce.edu.Academico.Service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("listStudents")
    public String listStudents(Model model) {
        model.addAttribute("studentList", studentService.listStudents());
        return "list_students";
    }

    @GetMapping("showNewStudentForm")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @PostMapping("saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "/index";
    }

    @GetMapping("showUpdateStudentForm/{enrollmentNumber}")
    public String showUpdateStudentForm(@PathVariable(value = "enrollmentNumber") long enrollmentNumber, Model model) {
        Student student = studentService.getStudentByEnrollmentNumber(enrollmentNumber);
        model.addAttribute("student", student);
        return "update_student";
    }

    @GetMapping("/deleteStudent/{enrollmentNumber}")
    public String deleteStudent(@PathVariable(value = "enrollmentNumber") long enrollmentNumber) {
        studentService.deleteStudentByEnrollmentNumber(enrollmentNumber);
        return "/index";
    }
}
