package ac.za.mycput.config;
/*
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
public class SpringSecurityAdmin {
    /*
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoderAdmin(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChainAdmin(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .csrf(withDefaults())
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers(
                                        "/registerAdmin/**", // Allow admin registration
                                        "/index").permitAll()
                                .requestMatchers("/admins").hasRole("ADMIN")
                                .requestMatchers(
                                        "/students", "/students/new", "/students/edit/{id}", "/students/{id}",
                                        "/courses", "/courses/new", "/course/edit/{id}", "/course/{id}",
                                        "/department", "/department/new", "/department/edit/{id}", "/department/{id}")
                                .permitAll()
                )


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
                .passwordEncoder(passwordEncoderAdmin());
    }



}

     */

