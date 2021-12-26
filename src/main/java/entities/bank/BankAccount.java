package entities.bank;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "bank_account")
@Entity
public class BankAccount {
    @Id
    @Column(name = "account_number")
    private Long accountNumber;
    @OneToOne
    private BankAccountType bankAccountType;
    @OneToOne
    private BankCurrency bankCurrency;
    @Column(name = "bank_balance")
    private BigDecimal bankBalance;
    @ManyToOne(fetch = FetchType.EAGER)
    private BankCard bankCard;


}
