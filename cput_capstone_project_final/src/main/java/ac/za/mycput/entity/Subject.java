package ac.za.mycput.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // no argument contructor
@AllArgsConstructor
@Entity
@Table(name="subject")
public class Subject {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false,unique = true)
    @NotEmpty(message = "select name")
    private String subjectName;

    @Column(nullable=false)
    @Size(min = 50, message = "Text must be at least 50 characters long")
    @NotEmpty(message = "select description can not be empty")
    private String subjectDescription;

    @ManyToOne
    @JoinColumn(name = "courseName")
    private Course courseName;

}
