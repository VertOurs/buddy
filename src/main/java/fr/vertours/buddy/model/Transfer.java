package fr.vertours.buddy.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="date_of_transaction", nullable = false)
    @NotNull
    private LocalDateTime dateOfTransaction;

    @Column(name = "amount_no_tax", nullable = false, scale = 2)
    @NotNull
    private BigDecimal amountNoTax;

    @Column(nullable = false, scale = 2)
    @NotNull
    private BigDecimal tax;

    @Column(nullable = false)
    @NotBlank
    private String description;

    @ManyToOne
    private ApplicationAccount sender;

    @ManyToOne
    private ApplicationAccount receiver;

    @ManyToOne
    private CreditCard creditCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public BigDecimal getAmountNoTax() {
        return amountNoTax;
    }

    public void setAmountNoTax(BigDecimal amountNoTax) {
        this.amountNoTax = amountNoTax;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApplicationAccount getSender() {
        return sender;
    }

    public void setSender(ApplicationAccount sender) {
        this.sender = sender;
    }

    public ApplicationAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(ApplicationAccount receiver) {
        this.receiver = receiver;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
