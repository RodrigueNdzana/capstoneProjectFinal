package ac.za.mycput.entity;

import jakarta.persistence.*;
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
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="courseCode", nullable=false,unique = true)
    @NotEmpty(message = "course code can not be empty")
    private String courseCode;

    @Column(name="courseDescription",nullable=false)
    @NotEmpty(message = "course description can not be empty")
    private String courseDescription;

    @Column(name="courseName",nullable = false)
    @NotEmpty(message = "course name can not be empty")
    private String courseName;

    @Column(name="startDate",nullable = false)
    private String startDate;

    @Column(name="endDate",nullable = false)
    private String endDate;

    @Column(name="department",nullable=false,unique = true)
    @NotEmpty(message = "department name can not be empty")
    private String department;

    @Column(name="className",nullable = false)
    private String className;

}


