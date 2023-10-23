package ac.za.mycput.controller;

import ac.za.mycput.entity.Administrator;
import ac.za.mycput.entity.User;
import ac.za.mycput.security.SecurityService;
import ac.za.mycput.service.impl.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
public class AuthController {

    private UserService userService;



    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/index")
    public String home(){
        return "index";
    } // tymeleaf home page

    // handler method to handle login request
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Validated @ModelAttribute("user") User userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        //User newUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the email");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "register";
        }
        // Check if the entered email contains "@mycput.ac.za" it one of cput rule to make sure that it is really a student
        if (!userDto.getEmail().toLowerCase().contains("@mycput.ac.za")) {
            result.rejectValue("email", "email.invalid", "Email must contain '@mycput.ac.za'");
            return "/register";
        }
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    // handler method to handle list of users
//    @GetMapping("/users")
//    public String users(Model model, User user, String keyword){
////        List<UserDto> users = userService.findAllUsers();
////        model.addAttribute("users", users);
//        //return "users";
//        if(keyword!=null) {
//            List<User> userList = userService.findByKeyword(keyword);
//            model.addAttribute("users", userList);
//        }else {
//            List<UserDto> users = userService.findAllUsers();
//            model.addAttribute("users", users);}
//        return "users";
//    }
    @GetMapping("/users")
    public String getUsers(Model model, String keyword) {
        // Your code to retrieve and populate user data
//        List<UserDto> userList = userService.findByKeyword(keyword);
//        model.addAttribute("users", userList);
//        return "users";
        List<User> list;
        if(keyword!=null) {
            list = userService.findByKeyword(keyword);
        }else {
            list = userService.findAllUsers();
        }
        model.addAttribute("users", list.get(list.size() - 1));
        return "users";

    }

    // admin
    @GetMapping("/loginAdmin")
    public String loginAdmin(){

        return "loginAdmin";
    }
    @GetMapping("/registerAdmin")
    public String showRegistrationFormAdmin(Model model){
        // create model object to store form  admin data
        Administrator admin = new Administrator();
        model.addAttribute("admin", admin);
        return "registerAdmin";
    }



    @PostMapping("/register/saveAdmin")
    public String registrationAdmin(@Validated @ModelAttribute("admin") Administrator admin,
                                    BindingResult result,
                                    Model model){
        Administrator existingAdmin = userService.findAdminByEmail(admin.getEmail());
        //User newUser = userService.findUserByEmail(userDto.getEmail());

        if(existingAdmin != null && existingAdmin.getEmail() != null && !existingAdmin.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the email");
        }
        if(result.hasErrors()){
            model.addAttribute("admin", admin);
            return "registerAdmin";
        }

        if (!admin.getEmail().toLowerCase().contains("@cput.ac.za")) {
            result.rejectValue("email", "email.invalid", "Email must contain @cput.ac.za");
            return "/registerAdmin";
        }
        userService.saveAdmin(admin);
        return "redirect:/registerAdmin?success";
    }
    @GetMapping("/admins")
    public String admins(Model model){
        List<Administrator> admins = userService.findAllAdmin();
        model.addAttribute("admins", admins);
        return "admins";
    }

}

