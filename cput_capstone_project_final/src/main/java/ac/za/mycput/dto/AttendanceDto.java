package ac.za.mycput.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDto {
    private Long attendanceId;
    @NotEmpty
    private String courseAttended;
    @NotEmpty
    private String date;

    @NotEmpty(message = "studentPresent should not be empty")
    private String studentPresent;
}
