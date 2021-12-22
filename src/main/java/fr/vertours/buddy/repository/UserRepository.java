package fr.vertours.buddy.repository;

import fr.vertours.buddy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByMail(String email);

}
