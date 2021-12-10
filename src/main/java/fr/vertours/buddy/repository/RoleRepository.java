package fr.vertours.buddy.repository;

import fr.vertours.buddy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
