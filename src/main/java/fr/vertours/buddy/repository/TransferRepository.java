package fr.vertours.buddy.repository;

import fr.vertours.buddy.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
