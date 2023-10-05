package ac.za.mycput.repository;

import ac.za.mycput.entity.Student;
import ac.za.mycput.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByEmail(String email);
}
