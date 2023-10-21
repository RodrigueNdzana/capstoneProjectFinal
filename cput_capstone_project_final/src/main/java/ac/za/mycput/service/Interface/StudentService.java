package ac.za.mycput.service.Interface;
/* Author: Rodrigue Ndzana , 219384096

 */
import ac.za.mycput.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

    Student getStudentByEmail(String email);
}
