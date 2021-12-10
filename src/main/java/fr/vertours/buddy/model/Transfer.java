package fr.vertours.buddy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="date_of_transaction", nullable = false)
    private LocalDateTime dateOfTransaction;

    @Column(name = "amount_no_tax", nullable = false)
    private BigDecimal amountNoTax;

    @Column(name = "tax", nullable = false)
    private BigDecimal tax;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private ApplicationAccount sender;

    @ManyToOne
    private ApplicationAccount receiver;

    @ManyToOne
    private CreditCard creditCard;
}
