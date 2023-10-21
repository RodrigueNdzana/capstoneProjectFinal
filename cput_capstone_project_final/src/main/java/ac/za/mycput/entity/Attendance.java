package ac.za.mycput.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.security.auth.Subject;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor // no argument contructor
@AllArgsConstructor
@Entity
@Table(name="attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotEmpty(message = "select date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "student_id") // Specify a unique column name for the Student association
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id") // Specify a unique column name for the Course association
    private Course course;

    @ManyToOne
    @JoinColumn(name = "educator_id") // Specify a unique column name for the Educator association
    private Educator educator;

    private boolean present;



}
