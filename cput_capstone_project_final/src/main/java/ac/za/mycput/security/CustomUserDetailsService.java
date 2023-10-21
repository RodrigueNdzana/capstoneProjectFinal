package ac.za.mycput.security;


import ac.za.mycput.entity.Administrator;
import ac.za.mycput.entity.Role;
import ac.za.mycput.entity.User;
import ac.za.mycput.repository.AdministratorRepository;
import ac.za.mycput.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service("CustomUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;
    private AdministratorRepository administratorRepository;

    public CustomUserDetailsService(UserRepository userRepository, AdministratorRepository administratorRepository) {

        this.userRepository = userRepository;
        this.administratorRepository = administratorRepository;
    }


    /*
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        Administrator admin = administratorRepository.findByEmail(email);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));

        } else {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

     */

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Check if it's a regular user
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }

        // Check if it's an admin
        Administrator admin = administratorRepository.findByEmail(email);
        if (admin != null) {
            return new org.springframework.security.core.userdetails.User(admin.getEmail(),
                    admin.getPassword(),
                    mapRolesToAuthorities(admin.getRoles()));
        }

        throw new BadCredentialsException("Invalid username or password");
    }


private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        Collection<? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }

}







