package ac.za.mycput.repository;

/*
This above code defines a Spring Data JPA repository interface called RoleRepository that extends the JpaRepository interface. The JpaRepository interface provides several methods for performing CRUD (Create, Read, Update, Delete) operations on a JPA entity, and it takes two type parameters: the entity type, Role, and the type of the entity's primary key, Long.

In addition to the methods provided by JpaRepository, the RoleRepository interface also declares a custom method called findByName(). This method uses Spring Data JPA's method name query creation feature to generate a query that finds a role by its name. The method takes a single argument, which is the role name to search for, and it returns a Role object
if a match is found, or null otherwise.
 */
import ac.za.mycput.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}