package ac.za.mycput.service.impl;



import ac.za.mycput.entity.Administrator;
import ac.za.mycput.entity.Role;
import ac.za.mycput.entity.User;
import ac.za.mycput.repository.AdministratorRepository;
import ac.za.mycput.repository.RoleRepository;
import ac.za.mycput.repository.UserRepository;
import ac.za.mycput.service.Interface.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
private UserService userService;
    private AdministratorRepository administratorRepository;


    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository
                           ,AdministratorRepository administratorRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.administratorRepository= administratorRepository;


    }



//    @Override
//    public RedirectView saveUser(UserDto userDto, RedirectAttributes redirectAttributes) {
//        String url = "/login?error=true";
//        User user = new User();
//        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
//        user.setEmail(userDto.getEmail());
//
//        //encrypt the password once we integrate spring security
//        //user.setPassword(userDto.getPassword());
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        Role role = roleRepository.findByName("ROLE_STUDENT");
//        if(role == null){
//            role = checkRoleExist();
//            //System.out.println(url);
//        }
//        user.setRoles(Arrays.asList(role));
//        userRepository.save(user);
//        // Add a success message
//        redirectAttributes.addFlashAttribute("registrationSuccessMessage", "Registration successful. Please log in.");
//
//        // Redirect to the login page
//        return new RedirectView("/login");
//    }



    @Override
    public RedirectView saveUser(User user) {
        String url = "/login?error=true";
        //User user = new User();
        user.setFirstName(user.getFirstName() + " " + user.getLastName());
        user.setEmail(user.getEmail());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("ROLE_STUDENT");
        if(role == null){
            role = checkRoleExist();
            //System.out.println(url);
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
        // Add a success message
        //redirectAttributes.addFlashAttribute("registrationSuccessMessage", "Registration successful. Please log in.");

        // Redirect to the login page
        return new RedirectView("/login");
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }


    private User convertEntityToDto(User user){
       // User userDto = new UserDto();
        String[] name = user.getFirstName().split(" ");
        if (name.length == 2) {
            user.setFirstName(name[0]);
            user.setLastName(name[1]);
        } else if (name.length == 1) {
            user.setFirstName(name[0]);
            // Handle the absence of the last name, e.g., set it to an empty string or null
            user.setLastName(""); // or userDto.setLastName(null);
        }
        return user;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_STUDENT");
        return roleRepository.save(role);
    }
    /*--------------- ADMIN -------------*/
    @Override
    public void saveAdmin(Administrator admin) {
        //Administrator admin = new Administrator();
        admin.setFirstName(admin.getFirstName() + " " + admin.getLastName());
        admin.setEmail(admin.getEmail());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Role roleAdmin = roleRepository.findByName("ROLE_ADMIN");
        if(roleAdmin == null){
            roleAdmin = checkRoleExistForAdmin();
        }
        admin.setRoles(Arrays.asList(roleAdmin));
        administratorRepository.save(admin);

    }

    @Override
    public Administrator findAdminByEmail(String email) {
        return administratorRepository.findByEmail(email);
    }

    @Override
    public List<Administrator> findAllAdmin() {
        List<Administrator> admins = administratorRepository.findAll();
        return admins.stream().map((administrator) -> convertEntityToDtoAdmin(administrator))
                .collect(Collectors.toList());
    }
    private Administrator convertEntityToDtoAdmin(Administrator administrator){
        Administrator adminDTO = new Administrator();
        String[] name = administrator.getFirstName().split(" ");
        adminDTO.setFirstName(name[0]);
        adminDTO.setLastName(name[1]);
        adminDTO.setEmail(administrator.getEmail());
        return adminDTO;
    }
    private Role checkRoleExistForAdmin() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
    /*
    * Search user by keyword(name)
     */
    @Override
    public List<User> findByKeyword(String keyword){

        return userRepository.findByKeyword(keyword);
    }


}