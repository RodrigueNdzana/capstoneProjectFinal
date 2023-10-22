package ac.za.mycput.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "firstname") // Specify a unique column name for the Student association
    private Student studentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseName") // Specify a unique column name for the Course association
    private Course courseName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "educatorName") // Specify a unique column name for the Educator association
    private Educator educatorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subjectName") // Specify a unique column name for the subject association
    private Subject subjectName;


    private boolean present;



}
