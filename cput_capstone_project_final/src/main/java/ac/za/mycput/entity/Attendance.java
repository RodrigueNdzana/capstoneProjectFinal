package ac.za.mycput.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor // no argument contructor
@AllArgsConstructor
@Entity
@Table(name="Attendance")
public class Attendance {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @Column(nullable = false)
    @NotEmpty(message = "class should not be empty")
    private String courseAttended;

    @Column(nullable = false)
    @NotEmpty(message = "studentPresent should not be empty")
    private String studentPresent;



}
