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
@Table(name="department")
public class Department {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false,unique = true)
    @NotEmpty(message = "The department Id can not be empty")
    private String departmentId;

    @Column(nullable=false)
    @NotEmpty(message = "Admin name can not be empty")
    private String adminName;

    @Column(nullable=false)
    @NotEmpty(message = "department name can not be empty")
    private String departmentName;

    @Column(nullable=false)
    @NotEmpty(message = "department description can not be empty")
    private String departmentDescription;
}


