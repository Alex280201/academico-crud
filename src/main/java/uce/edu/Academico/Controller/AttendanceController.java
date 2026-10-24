package uce.edu.Academico.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uce.edu.Academico.Model.Attendance;
import uce.edu.Academico.Model.Student;
import uce.edu.Academico.Service.AttendanceService;
import uce.edu.Academico.Service.StudentService;

@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentService studentService;

    @GetMapping("showNewAttendanceForm/{enrollmentNumber}")
    public String showNewAttendanceForm(
            @PathVariable(value = "enrollmentNumber") long enrollmentNumber, Model model) {

        Student student = studentService.getStudentByEnrollmentNumber(enrollmentNumber);
        Attendance attendance = new Attendance();
        attendance.setStudent(student);

        model.addAttribute("attendance", attendance);
        return "new_attendance";
    }

    @PostMapping("saveAttendance")
    public String saveAttendance(
            @ModelAttribute("attendance") Attendance attendance) {

        attendanceService.saveAttendance(attendance);
        return "/index";
    }

    @GetMapping("listAttendances")
    public String listAttendances(Model model) {
        model.addAttribute("attendanceList", attendanceService.listAttendances());
        return "list_attendances";
    }
}
