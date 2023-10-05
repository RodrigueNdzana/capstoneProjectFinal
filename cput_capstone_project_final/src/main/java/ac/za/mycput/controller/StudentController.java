package ac.za.mycput.controller;

/* Author : Rodrigue Ndzana , 219384096
Handle request made by the client

 */



import ac.za.mycput.entity.Course;
import ac.za.mycput.entity.Student;
import ac.za.mycput.service.Interface.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;



@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @PostMapping("/resetSuccessMessage")
    public ResponseEntity<Void> resetSuccessMessage(HttpSession session) {
        session.removeAttribute("successMessage");
        return ResponseEntity.ok().build();
    }
    // handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "/studentsFunctionality/students";
    }
    // request to get the add student page
    @GetMapping("/students/new")
    public String createStudentForm(Model model) {

        // create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "/studentsFunctionality/createStudent";

    }
    // save student in the database

    @PostMapping("/students")
    public String saveStudent(@Validated @ModelAttribute("student") Student student,BindingResult bindingResult,Model model, HttpSession session) {
        Student existingStudent = studentService.getStudentByEmail(student.getEmail());

        if(existingStudent != null && existingStudent.getEmail() != null && !existingStudent.getEmail().isEmpty()){
            bindingResult.rejectValue("email", null,
                    "There is already an student with the email");
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("student", student);
            return "/studentsFunctionality/createStudent";
        }
        // Check if the entered email contains "@mycput.ac.za" it one of cput rule to make sure that it is really a student
        if (!student.getEmail().toLowerCase().contains("@mycput.ac.za")) {
            bindingResult.rejectValue("email", "email.invalid", "Email must contain '@mycput.ac.za'");
            return "/studentsFunctionality/createStudent";
        }
        studentService.saveStudent(student);
        session.setAttribute("successMessage", "Student Successfully Added");
        return "redirect:/students/new?success";
        // Wait for 5 seconds (5000 milliseconds)
    }

    // request to get the update page
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "/studentsFunctionality/editStudent";
    }

    // update data with a specific ID
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model,HttpSession session) {

        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastname(student.getLastname());
        existingStudent.setEmail(student.getEmail());

        // save updated student object
        studentService.updateStudent(existingStudent);
        session.setAttribute("successMessage", "Student has been Successfully Updated");
        return "redirect:/students";
    }

    // handler method to handle delete student request

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id,HttpSession session) {

        studentService.deleteStudentById(id);
        session.setAttribute("successMessage", "Student Successfully Deleted");
        return "redirect:/students";
    }
}




