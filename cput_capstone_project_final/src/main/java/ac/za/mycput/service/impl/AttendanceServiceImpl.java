package ac.za.mycput.service.impl;

import ac.za.mycput.entity.Attendance;
import ac.za.mycput.repository.AttendanceRepository;
import ac.za.mycput.service.Interface.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    private AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        super();
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public Attendance findAttendanceByAttendanceId(String attendanceId) {
        return attendanceRepository.findAttendanceByAttendanceId(attendanceId);
    }

    @Override
    public Attendance updateAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public void deleteAttendanceByAttendanceId(Long attendanceId) {
        attendanceRepository.deleteAttendanceByAttendanceId( attendanceId);
    }
}