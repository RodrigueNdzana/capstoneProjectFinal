package ac.za.mycput.repository;

import ac.za.mycput.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByEmail(String email);
   // String findByFirstname(Student firstName);
    @Query(value = "select * from students s where s.firstname like %:keyword% or s.email like %:keyword%", nativeQuery = true)
    List<Student> findByKeyword(@Param("keyword") String keyword);

    Student findByFirstname(String firstName);
}
