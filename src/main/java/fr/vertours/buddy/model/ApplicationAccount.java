package fr.vertours.buddy.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "application_account")
public class ApplicationAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String numberAccount;

                                                                                //OneToOne
    @OneToOne(optional = false)
    @JoinColumn(name = "user", nullable = false)
    private User user;

    @Column(nullable = false)
    private BigDecimal balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
