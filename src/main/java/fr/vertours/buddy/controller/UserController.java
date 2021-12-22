package fr.vertours.buddy.controller;

import fr.vertours.buddy.model.User;
import fr.vertours.buddy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    // WARNING Mapping path not definitive.
    @GetMapping("/postman")
        public User getUserByEmail(@RequestParam("mail") String email) {
        return userService.findByEmail(email);

    }

    @DeleteMapping("/deleteFriend")
    public void deleteOneConnectionOfOneUser(
            @RequestParam("friendId") Long friendId,
            @RequestParam("userId") Long userId){

        userService.deleteFriendWithUserId(friendId, userId);
        // Find on the Web, is it a good idea ? = return "redirect:/Contact";
    }
}
