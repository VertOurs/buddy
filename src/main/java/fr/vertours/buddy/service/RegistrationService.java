package fr.vertours.buddy.service;

import fr.vertours.buddy.configuration.SecurityConfiguration;
import fr.vertours.buddy.dto.RegistrationDTO;
import fr.vertours.buddy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RegistrationService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    public void userRegistration (RegistrationDTO registrationDTO) {
       String securePassword = passwordEncoder.encode(registrationDTO.getPassword());

       User user = new User();
       user.setFirstName(registrationDTO.getFirstName());
       user.setLastName(registrationDTO.getLastName());
       user.setMail(registrationDTO.getMail());
       user.setPassword(securePassword);

       userService.saveUser(user);

    }
    @PostConstruct
    public void init() {
        User user = new User();
        user.setFirstName("Martin");
        user.setLastName("Dupond");
        user.setMail("martin-dupond@gmail.com");
        user.setPassword(passwordEncoder.encode("azerty"));
        if(userService.findByEmail(user.getMail()) == null) {
            userService.saveUser(user);
        }
    }

}
