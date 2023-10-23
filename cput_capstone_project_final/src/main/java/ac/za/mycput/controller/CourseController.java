package ac.za.mycput.controller;

/* Author : Rodrigue Ndzana , 219384096
Handle request made by the client

 */





import ac.za.mycput.entity.Course;
import ac.za.mycput.service.impl.Interface.CourseService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        super();
        this.courseService = courseService;
    }

    //    @PostMapping("/resetSuccessMessageCourse")
//    public ResponseEntity<Void> resetSuccessMessage(HttpSession session) {
//        session.removeAttribute("successMessage");
//        return ResponseEntity.ok().build();
//    }
    // handler method to handle list students and return mode and view
    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "/courseFunctionality/courses"; // return the front-end  view
    }
    // request to get the add course page
    @GetMapping("/courses/new")
    public String createCourseForm(Model model) {

        // create course object to hold course form data
        Course course = new Course();
        model.addAttribute("course", course);
        return "/courseFunctionality/createCourse";

    }
    // save course in the database
    @PostMapping("/courses")
    public String saveCourse(@Validated @ModelAttribute("course") Course course, BindingResult bindingResult, Model model, HttpSession session) {
        Course existingCourse = courseService.getByCourseCode(course.getCourseCode());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;

        try {
            String startDateString = course.getStartDate();
            String endDateString = course.getEndDate();

            if (startDateString != null && !startDateString.isEmpty() &&
                    endDateString != null && !endDateString.isEmpty()) {
                startDate = sdf.parse(startDateString);
                endDate = sdf.parse(endDateString);

                // check if the start date is less than the end date
                if (startDate.compareTo(endDate) < 0) {
                    course.setStartDate(String.valueOf(startDate));
                    course.setEndDate(String.valueOf(endDate));

                }else if (startDate.compareTo(endDate) == 0) {
                    // Start date and end date are the same validation
                    bindingResult.rejectValue("startDate", null,
                            "start date can not be the same with the end date");
                }
                else {
                    // Handle the case where the start date is not before the end date
                    // returning an error
                    bindingResult.rejectValue("startDate", null,
                            "start date can not be greater than the end date");
                }
            } else {
                // Handle the case where the date strings are empty or null

                bindingResult.rejectValue("startDate", null,
                        "start date field can not be null");
                bindingResult.rejectValue("endDate", null,
                        "end date field can not be null");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(existingCourse != null && existingCourse.getCourseCode() != null && !existingCourse.getCourseCode().isEmpty()){
            bindingResult.rejectValue("courseCode", null,
                    "There is already an course with the code");
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("course", course);
            return "/courseFunctionality/createCourse";
        }
//        // Check if the entered email contains "@mycput.ac.za" it one of cput rule to make sure that it is really a student
//        if (!course.getEmail().toLowerCase().contains("@mycput.ac.za")) {
//            bindingResult.rejectValue("email", "email.invalid", "Email must contain '@mycput.ac.za'");
//            return "/departmentsFunctionality/createCourse";
//        }
        courseService.saveCourse(course);
        session.setAttribute("successMessage", "Course Successfully Added");
        return "redirect:/courses/new?success";

    }

    // request to get the update page
    @GetMapping("/courses/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseService.getCourseById(id));
        return "/courseFunctionality/editCourse";
    }

    // update data with a specific ID
    @PostMapping("/course/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute("course") Course course,
                               Model model,HttpSession session) {

        // Convert the date input to a java.util.Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(course.getStartDate());
            endDate = sdf.parse(course.getEndDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // get course from database by id
        Course existingCourse = courseService.getCourseById(id);
        existingCourse.setId(id);
        existingCourse.setCourseCode(course.getCourseCode());
        existingCourse.setCourseDescription(course.getCourseDescription());
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setStartDate(String.valueOf(startDate));
        existingCourse.setEndDate(String.valueOf(endDate));
        existingCourse.setDepartment(course.getDepartment());
        existingCourse.setClassName(course.getClassName());

        // save updated course object
        courseService.updateCourse(existingCourse);
        session.setAttribute("successMessage", "course has been Successfully Updated");
        return "redirect:/courses";
    }

    // handler method to handle delete student request
    @Transactional
    @GetMapping("/courses/{courseName}")
    public String deleteCourse (@PathVariable String courseName,HttpSession session) {

        courseService.deleteByCourseName(courseName);
        session.setAttribute("successMessage", "Student Successfully Deleted");
        return "redirect:/courses";
    }
}






