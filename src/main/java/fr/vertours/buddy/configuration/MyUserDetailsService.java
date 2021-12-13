package fr.vertours.buddy.configuration;

import fr.vertours.buddy.model.User;
import fr.vertours.buddy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user=  userRepository.findByMail(mail);
        UserDetails  userD = new MyUserDetails(user.getRole(), user.getPassword(), user.getMail());
        return userD;
    }
}
