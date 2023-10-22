package ac.za.mycput.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SpringSecurity {


    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/register/**", "/registerAdmin/**").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/users").hasRole("STUDENT")
                                .requestMatchers("/users/edit/{id}", "/users/{id}").permitAll()
                                .requestMatchers("/admins").hasRole("ADMIN")
                                .requestMatchers("/students", "/searchStudent", "/searchStudentAdmin", "/students/new",
                                        "/students/edit/{id}", "/students/{id}").permitAll()
                                .requestMatchers("/courses", "/courses/new", "/courses/edit/{id}").permitAll()
                                .requestMatchers("/department", "/department/new", "/department/edit/{id}", "/department/{id}").permitAll()
                                .requestMatchers("/markAttendanceForm", "/attendanceReport").permitAll()
                                .requestMatchers("/educators", "/educators/new", "/educators/edit/{id}",
                                        "/searchEducatorAdmin", "/searchEducatorUser").permitAll()
                                .requestMatchers("/subjects", "/subjects/new", "/subjects/edit/{id}", "/subjects/{id}",
                                        "/searchSubject", "/searchSubjectAdmin").permitAll()
                )
//                .formLogin(
//                        form -> form
//                                .loginPage("/login")
//                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/users") // after login user can create student
//                                .permitAll()
//                )
                .formLogin(formAdmin ->
                        formAdmin
                                .loginPage("/loginAdmin") // Admin login form
                                .loginProcessingUrl("/loginAdmin")
                                .defaultSuccessUrl("/admins") // After login, admin can create students
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );

        return http.build();
    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

}



