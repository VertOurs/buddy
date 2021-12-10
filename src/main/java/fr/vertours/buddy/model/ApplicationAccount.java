package fr.vertours.buddy.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "application_account")
public class ApplicationAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Column(nullable = false)
    private BigDecimal balance;
}
