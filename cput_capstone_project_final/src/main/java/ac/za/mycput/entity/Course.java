package ac.za.mycput.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor // no argument contructor
@AllArgsConstructor
@Entity
@Table(name="Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false,unique = true)
    @NotEmpty(message = "course code can not be empty")
    private String courseCode;

    @Column(nullable=false,unique = true)
    @NotEmpty(message = "course description can not be empty")
    private String courseDescription;

    @Column(nullable = false)
    @NotEmpty(message = "course name can not be empty")
    private String courseName;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable=false,unique = true)
    @NotEmpty(message = "department name can not be empty")
    private String department;

    @Column(nullable = false)
    private String className;

   

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "enrolled_Student",
            joinColumns = {@JoinColumn(name = "Course_Id",referencedColumnName = "id")},
            inverseJoinColumns= {@JoinColumn(name = "Student_Name", referencedColumnName = "firstname")}
    )
    private List<Student> students= new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "enrolled_Student",
            joinColumns = {@JoinColumn(name = "Course_Id",referencedColumnName = "id")},
            inverseJoinColumns= {@JoinColumn(name = "Educator_Name", referencedColumnName = "educatorName")}
    )
    private List<Educator> educators= new ArrayList<>();


    public Course(int i, String adp3, String allAboutCoding, Date startDate, Date endDate, String technology, String s) {
    }
}
