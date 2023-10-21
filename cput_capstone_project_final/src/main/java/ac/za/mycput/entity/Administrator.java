package ac.za.mycput.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor // no argument contructor
@AllArgsConstructor
@Entity
@Table(name="administrator")
public class Administrator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false, unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL) //user can have many role. therefore we join user and role table.
    @JoinTable(
            name="admin_roles",
            joinColumns={@JoinColumn(name="ADMIN_ID", referencedColumnName="ID")}, // admin table
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")}) // role table -- the target entity
    private List<Role> roles= new ArrayList<>();
}
