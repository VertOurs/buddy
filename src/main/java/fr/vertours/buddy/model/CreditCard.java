package fr.vertours.buddy.model;

import javax.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Column(nullable = false)
    private String bank;

    @Column(nullable = false, unique = true)
    private String cardNumber;

    @Column(nullable = false)
    private int validityMonth;

    @Column(nullable = false)
    private int validityYear;

}
