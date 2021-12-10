package fr.vertours.buddy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String methodeHome(Model model) {
//        model.addAttribute("name", 47);
//        User user = new User();
//        user.setFirstName("47");
//        user.setLastName("booby");
//        user.setMail("bobby@gmal.com");
//
//        model.addAttribute("user",user);
        return "home";
    }
}
