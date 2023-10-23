package ac.za.mycput.entity;


/*

 */

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
@Table(name="educator")
public class Educator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false,unique = true)
    @NotEmpty(message = "Educator number can not be empty")
    private String educatorNumber;

    @Column(name = "educatorName",nullable=false)
    @NotEmpty(message = "Educator name can not be empty")
    private String educatorName;

    @Column(name = "educatorAddress", nullable = false)
    private String educatorAddress;

    @Column(name = "educatorGender",nullable = false)
    private String educatorGender;

    @ManyToOne
    @JoinColumn(name = "courseName")
    private Course course;

}

