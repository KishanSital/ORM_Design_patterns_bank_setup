package entities.bank;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    @Column
    private Long accountNumber;
    @OneToOne
    private AccountType accountType;
    @OneToOne
    private Currency currency;
    @Column
    private BigDecimal balance;
    @ManyToOne(fetch = FetchType.EAGER)
    private CreditCard creditCard;


}
