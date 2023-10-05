package ac.za.mycput.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

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

    @Column(nullable=false)
    @NotEmpty(message = "Educator name can not be empty")
    private String educatorName;

    @Column(nullable = false)
    private String educatorAddress;

    @Column(nullable = false)
    private String educatorGender;

    @ManyToMany(mappedBy="educators")
    private List<Course> courses;

}
