package ac.za.mycput.controller;

import ac.za.mycput.entity.Student;
import ac.za.mycput.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
class StudentControllerTest {

    @Test
    void listStudents() {
    }

    @Test
    void saveStudent() {
        //Student student1 = new Student(1L,"Rodrigue","Ndzana","219384096@mycput.ac.za");
     //studentRepository.save(student1);
    }

    @Test
    void updateStudent() {
    }

    @Test
    void deleteStudent() {
    }
}