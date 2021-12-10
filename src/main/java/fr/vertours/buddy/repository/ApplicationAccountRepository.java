package fr.vertours.buddy.repository;

import fr.vertours.buddy.model.ApplicationAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ApplicationAccountRepository extends JpaRepository<ApplicationAccount, Long> {
}
