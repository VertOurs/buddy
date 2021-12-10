package fr.vertours.buddy.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
                                                                                //ManyToOne
    @ManyToOne(optional = false)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Column(nullable = false)
    @NotBlank
    private String bank;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String cardNumber;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 1, max = 12)
    private int validityMonth;

    @Column(nullable = false)
    @NotBlank
    @Size(min=21, max =99)
    private int validityYear;

}
