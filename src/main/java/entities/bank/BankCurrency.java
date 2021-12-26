package entities.bank;

import javax.persistence.*;

@Table(name = "bank_currency")
@Entity
public class BankCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "currency_code")
    private String currencyCode;

}
