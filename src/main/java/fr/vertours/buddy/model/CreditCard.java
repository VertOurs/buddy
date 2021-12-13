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
    @Size(min = 2, max = 2)
    private String validityMonth;

    @Column(nullable = false)
    @NotBlank
    @Size(min = 2, max = 2)
    private String validityYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getValidityMonth() {
        return validityMonth;
    }

    public void setValidityMonth(String validityMonth) {
        this.validityMonth = validityMonth;
    }

    public String getValidityYear() {
        return validityYear;
    }

    public void setValidityYear(String validityYear) {
        this.validityYear = validityYear;
    }
}
