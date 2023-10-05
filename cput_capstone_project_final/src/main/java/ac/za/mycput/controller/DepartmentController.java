package ac.za.mycput.controller;
/*

 */


import ac.za.mycput.entity.Department;
import ac.za.mycput.service.Interface.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    // this method return the list of department that has been added in the database and return a model. and accessing the get
    @GetMapping("/department")
    public String listDepartment(Model model) {
        model.addAttribute("department", departmentService.getAllDepartment());
        return "/departmentsFunctionality/department"; // Return the name of the department.html Thymeleaf template
    }


    @GetMapping("/department/new")
    public String createDepartmentForm(Model model) {

        // calling the department object to hold data
        Department department = new Department();
        model.addAttribute("department", department);
        return "/departmentsFunctionality/createDepartment"; // make sure to create the html file with this name that is found inside student folder

    }
    // handler method to handle department to save data
    @PostMapping("/department")
    public String saveDepartment(@Validated @ModelAttribute("department") Department department,
                              BindingResult bindingResult,
                              Model model) {
        Department existingDepartment = departmentService.getDepartmentId(department.getDepartmentId());


        if (existingDepartment != null && existingDepartment.getDepartmentId() != null && !existingDepartment.getDepartmentId().isEmpty()) {
            bindingResult.rejectValue("departmentId", null,
                    "The above department has already been added please view the department to update or delete");
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("department", department);
            return "/departmentsFunctionality/createDepartment";
        }

        departmentService.saveDepartment(department);
        // when the student has been successfully added in the database we are redirecting to the student page. which is the method handle to return the list of student
        return "redirect:/department/new?success";

    }
    @GetMapping("/department/edit/{departmentId}")
    public String editDepartmentForm(@PathVariable String departmentId, Model model) {
        model.addAttribute("department", departmentService.getDepartmentId(departmentId));
        return "/departmentsFunctionality/editDepartment";
    }

    @PostMapping("/department/{departmentId}")
    public String updateDepartment(@PathVariable String departmentId,
                                @ModelAttribute("department") Department department,
                                Model model) {

        // get department from database by departmentId
        Department existingDepartment = departmentService.getDepartmentId(departmentId);
        existingDepartment.setId(department.getId());
        existingDepartment.setDepartmentId(department.getDepartmentId());
        existingDepartment.setAdminName(department.getAdminName());
        existingDepartment.setDepartmentName(department.getDepartmentName());
        existingDepartment.setDepartmentDescription(department.getDepartmentDescription());

        // save updated department object
        departmentService.updateDepartment(department);
        return "redirect:/department";
    }

    // handler method to handle delete department request
    @GetMapping("/department/{departmentId}")
    public String deleteDepartmentId(@PathVariable String departmentId) {
        departmentService.deleteDepartmentId(departmentId);
        return "redirect:/department";
    }

}


