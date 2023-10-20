package ac.za.mycput.controller;

import ac.za.mycput.service.Interface.AttendanceService;
import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AttendanceController {
    private AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        super();
        this.attendanceService = attendanceService;
    }
    @GetMapping("/attendance")
    public String listAttendance(Model model) {
        model.addText("attendance",attendanceService.getAllAttendance());
        return "/attendanceFunctionality/attendance";

    }

}