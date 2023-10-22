package ac.za.mycput.entity;

import lombok.Data;

@Data
public class AttendanceRecord {
    private String studentName;
    private String subject;
    private boolean attendanceStatus;
}
