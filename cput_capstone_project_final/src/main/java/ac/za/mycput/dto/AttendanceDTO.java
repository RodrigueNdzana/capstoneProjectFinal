package ac.za.mycput.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {
    @NotEmpty(message = "Email should not be empty")
    private Long studentId;
    @NotEmpty(message = "Email should not be empty")
    private Long educatorId;
    @NotEmpty(message = "Email should not be empty")
    private Long subjectId;
    @NotEmpty(message = "Email should not be empty")
    private Long courseId;
    private LocalDate date;
    private Long departmentId;
    private Boolean isPresent;


}
