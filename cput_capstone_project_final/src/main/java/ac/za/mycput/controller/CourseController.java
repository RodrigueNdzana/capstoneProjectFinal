package ac.za.mycput.controller;


import ac.za.mycput.entity.Course;
import ac.za.mycput.entity.Student;
import ac.za.mycput.service.Interface.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin()
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        super();
        this.courseService = courseService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/course")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "/courseFunctionality/course";
    }

    @GetMapping("/course/new")
    public String createCourseForm(Model model) {

        // create student object to hold student form data
        Course course = new Course();
        model.addAttribute("course", course);
        return "/courseFunctionality/create_course";

    }

    @PostMapping("/course")
    public String saveCourse(@Validated @ModelAttribute("course") Course course,BindingResult bindingResult,Model model){
        Course existingCourse = courseService.findCourseByCode(course.getCourseCode());

        if (existingCourse != null) {
            bindingResult.rejectValue("course", null,
                    "The above course has already been added");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("course", course);
            return "/courseFunctionality/course";
        }

        courseService.saveCourse(course);
        return "redirect:/course";
    }

    @GetMapping("/course/edit/{courseCode}")
    public String editCourseForm(@PathVariable String courseCode, Model model) {
        model.addAttribute("course", courseService.findCourseByCode(courseCode));
        return "/courseFunctionality/edit_course";
    }

    @PostMapping("/course/{courseCode}")
    public String updateCourse(@PathVariable String courseCode,
                                @ModelAttribute("course")  Course course,
                                Model model) {

        // get course from database by id
        Course existingCourse =  courseService.findCourseByCode(course.getCourseCode());
        //existingCourse.setId(id);
        existingCourse.setCourseCode(course.getCourseCode());
        existingCourse.setCourseDescription(course.getCourseDescription());
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setStartDate(course.getStartDate());
        existingCourse.setEndDate(course.getEndDate());
        existingCourse.setDepartment(course.getDepartment());
        existingCourse.setClassName(course.getClassName());

        // save updated course object
        courseService.updateCourse(existingCourse);
        return "redirect:/course";
    }

    // handler method to handle delete student request

    @GetMapping("/course/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourseById(id);
        return "redirect:/course";
    }

}