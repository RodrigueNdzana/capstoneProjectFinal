package ac.za.mycput.service.impl.Interface;

import ac.za.mycput.entity.Administrator;
import ac.za.mycput.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public interface UserService {

    @Query(value = "select * from users u where u.first_name like %:keyword% or u.email like %:keyword%", nativeQuery = true)
    List<User> findByKeyword(@Param("keyword") String keyword);

    RedirectView saveUser(User user);

    User findUserByEmail(String email);

    List<User> findAllUsers();

    // admin
    void saveAdmin(Administrator admin);
    Administrator findAdminByEmail(String email);
    List<Administrator> findAllAdmin();

    User getUserById(Long id);

    void deleteUserById(Long id);

    User updateUserDetail(User existingUser);
}
