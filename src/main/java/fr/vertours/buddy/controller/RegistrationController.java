package fr.vertours.buddy.controller;

import fr.vertours.buddy.dto.RegistrationDTO;
import fr.vertours.buddy.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/registration")
    public String displayRegistrationPage(RegistrationDTO registrationDTO) {

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid RegistrationDTO registrationDTO) {
        registrationService.userRegistration(registrationDTO);

        return "confirmation";

    }
}
