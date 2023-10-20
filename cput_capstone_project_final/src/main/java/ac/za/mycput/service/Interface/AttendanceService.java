package ac.za.mycput.service.Interface;

import ac.za.mycput.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getAllAttendance();

    Attendance saveAttendance(Attendance attendance);

    Attendance findAttendanceByAttendanceId(String attendanceId);

    Attendance updateAttendance(Attendance attendance);

    void deleteAttendanceByAttendanceId(Long attendanceId);
}
