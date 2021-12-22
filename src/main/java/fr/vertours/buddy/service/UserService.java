package fr.vertours.buddy.service;

import fr.vertours.buddy.model.User;
import fr.vertours.buddy.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByMail(email);
    }

    public void deleteFriendWithUserId(Long friendId, Long userId) {
        User mainUser = userRepository.getById(userId);
        //intellij proposition for replace my loop
        mainUser.getMyFriendList().removeIf(u -> u.getId() == friendId);
        userRepository.save(mainUser);
    }
}
