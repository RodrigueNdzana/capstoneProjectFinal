package ac.za.mycput.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor // no argument contructor
@AllArgsConstructor
@Entity
@Table(name="students")
public class Student {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "firstname should not be empty")
    private String firstname;

    @Column(nullable = false)
    @NotEmpty(message = "lastname should not be empty")
    private String lastname;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "email should not be empty")
    private String email;

//    @ManyToOne
//    @JoinColumn(name = "id") // Use @JoinColumn to specify the foreign key column
//    private Student student;
}