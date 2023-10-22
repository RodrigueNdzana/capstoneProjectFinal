package ac.za.mycput.database;

import java.util.ArrayList;
import java.util.List;
import ac.za.mycput.entity.AttendanceRecord;

public class AttendanceDatabase {
    private static List<AttendanceRecord> records = new ArrayList<>();

    public static void addAttendanceRecord(AttendanceRecord record) {
        records.add(record);
    }

    public static List<AttendanceRecord> getAllAttendanceRecords() {
        return records;
    }
}
