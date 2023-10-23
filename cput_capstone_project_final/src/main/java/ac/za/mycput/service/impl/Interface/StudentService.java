package ac.za.mycput.service.impl.Interface;
/* Author: Rodrigue Ndzana , 219384096

 */
import ac.za.mycput.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

    Student getStudentByEmail(String email);

    Student findByFirstname(String firstName);

    @Query(value = "select * from students s where s.firstname like %:keyword% or s.email like %:keyword%", nativeQuery = true)
    List<Student> findByKeyword(@Param("keyword") String keyword);
}
