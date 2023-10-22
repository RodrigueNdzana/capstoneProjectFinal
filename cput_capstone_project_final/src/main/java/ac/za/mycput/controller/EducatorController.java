package ac.za.mycput.controller;


import ac.za.mycput.entity.Course;
import ac.za.mycput.entity.Educator;
import ac.za.mycput.repository.CourseRepository;

import ac.za.mycput.service.impl.Interface.EducatorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class EducatorController {
    private EducatorService educatorService;
    @Autowired
    private CourseRepository courseRepository;


    public EducatorController(EducatorService studentService) {
        super();
        this.educatorService = studentService;
    }

    @PostMapping("/resetEducatorSuccessMessage")
    public ResponseEntity<Void> resetSuccessMessage(HttpSession session) {
        session.removeAttribute("successMessage");
        return ResponseEntity.ok().build();
    }
    // handler method to handle list educator and return mode and view
    @GetMapping("/educators")
    public String listEducators(Model model) {

        model.addAttribute("educators", educatorService.getAllEducators());
        return "/educatorFunctionality/educators";
    }
    // request to get the add student page
    @GetMapping("/educators/new")
    public String createEducatorForm(Model model) {
        // gender
        List<String> genderOptions = Arrays.asList("Male", "Female");
        model.addAttribute("genders", genderOptions);
        List<Course> course = courseRepository.findAll();
        model.addAttribute("courses", course);
        // create student object to hold student form data
        Educator educator = new Educator();
        model.addAttribute("educator", educator);
        return "/educatorFunctionality/createEducator";

    }
    // save student in the database

    @PostMapping("/educators")
    public String saveEducator(@Validated @ModelAttribute("educator") Educator educator, BindingResult bindingResult, Model model, HttpSession session) {
        Educator existingEducator = educatorService.getByEducatorNumber(educator.getEducatorNumber());

        if(existingEducator != null && existingEducator.getEducatorNumber() != null && !existingEducator.getEducatorNumber().isEmpty()){
            bindingResult.rejectValue("educatorNumber", null,
                    "There is already an educator with the email");
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("educator",educator);
            return "/educatorFunctionality/createEducator";
        }
        // Check if the entered email contains "@mycput.ac.za" it one of cput rule to make sure that it is really a student
        if (!educator.getEducatorNumber().toLowerCase().contains("@cput.ac.za")) {
            bindingResult.rejectValue("email", "email.invalid", "educator number must contain '@cput.ac.za'");
            return "/educatorFunctionality/createEducator";
        }
        educatorService.saveEducator(educator);
        session.setAttribute("successMessage", "educator Successfully Added");
        return "redirect:/educators/new?success";
    }

    // request to get the update page for admin
    @GetMapping("/educators/edit/{id}")
    public String editEducatorForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", educatorService.getEducatorById(id));
        return "/educatorFunctionality/editEducator";
    }

    // request to get the update page for user
    @GetMapping("/searchEducatorUser")
    public String searchEducatorUser(@RequestParam(required = false) String keyword, Model model) {
        List<Educator> list;
        if (keyword != null && !keyword.isEmpty()) {
            list = educatorService.findByKeyword(keyword);
            model.addAttribute("educators", list);
        }

        return "/educatorFunctionality/searchEducator";

    }
    @GetMapping("/searchEducatorAdmin")
    public String searchStudentAdmin(@RequestParam(required = false) String keyword, Model model) {
        List<Educator> list;
        if (keyword != null) {
            list = educatorService.findByKeyword(keyword);

        }else{
            list = educatorService.getAllEducators();
        }
        model.addAttribute("educators", list);

        return "/educatorFunctionality/educators";

    }


    // update data with a specific ID
    @PostMapping("/educators/{id}")
    public String updateEducator(@PathVariable Long id,
                                @ModelAttribute("educator") Educator educator,
                                Model model,HttpSession session) {

        // get EDUCATOR from database by id
        Educator existingEducator = educatorService.getEducatorById(id);
        existingEducator.setId(id);
        existingEducator.setEducatorNumber(educator.getEducatorNumber());
        existingEducator.setEducatorName(educator.getEducatorName());
        existingEducator.setEducatorAddress(educator.getEducatorAddress());
        existingEducator.setEducatorGender(educator.getEducatorGender());
        existingEducator.setCourse(educator.getCourse());

        // save updated student object
        educatorService.updateEducator(existingEducator);
        session.setAttribute("successMessage", "educator has been Successfully Updated");
        return "redirect:/educators";
    }

    // handler method to handle delete student request

    @GetMapping("/educators/{id}")

    public String deleteEducator(@PathVariable Long id,HttpSession session) {

        educatorService.deleteEducatorById(id);
        session.setAttribute("successMessage", "educator has beem  Successfully Deleted");
        return "redirect:/educators";
    }


}
