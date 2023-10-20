package ac.za.mycput.repository;

import ac.za.mycput.entity.Attendance;
import ac.za.mycput.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository  extends JpaRepository<Attendance,Long> {
    Attendance findAttendanceByAttendanceId(String attendanceId);
    void deleteAttendanceByAttendanceId(Long attendanceId);
}
