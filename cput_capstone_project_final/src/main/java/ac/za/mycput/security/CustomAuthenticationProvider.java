package ac.za.mycput.security;
/*
import ac.za.mycput.entity.Administrator;
import ac.za.mycput.entity.User;
import ac.za.mycput.repository.AdministratorRepository;
import ac.za.mycput.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository for user details
    @Autowired
    private AdministratorRepository administratorRepository; // Assuming you have a repository for admin details

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.;

        // Check if it's a regular user
        User user = userRepository.findByEmail(username);
        if (user != null) {
            // Create an authentication token for the user
            List<GrantedAuthority> authorities = user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(username, password, authorities);
        }

        // Check if it's an admin
        Administrator admin = administratorRepository.findByEmail(username);
        if (admin != null) {
            // Create an authentication token for the admin
            List<GrantedAuthority> authorities = admin.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList());
            return new UsernamePasswordAuthenticationToken(username, password, authorities);
        }

        throw new BadCredentialsException("Invalid username or password");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }



}
*/