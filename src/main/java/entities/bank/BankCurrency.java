package entities.bank;

import javax.persistence.*;

@Table(name = "bank_currency")
@Entity
public class BankCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(name = "currency_code", unique = true, nullable = false)
    private String currencyCode;

    public BankCurrency(Long id, String currencyCode) {
        this.id = id;
        this.currencyCode = currencyCode;
    }

    public BankCurrency() {

    }

    public BankCurrency(BankCurrencyBuilder bankCurrencyBuilder) {
        this.id = bankCurrencyBuilder.id;
        this.currencyCode = bankCurrencyBuilder.currencyCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public static class BankCurrencyBuilder {

        private Long id;

        private String currencyCode;

        public BankCurrencyBuilder id() {
            this.id = id;
            return this;
        }

        public BankCurrencyBuilder currencyCode() {
            this.currencyCode = currencyCode;
            return this;
        }

        public BankCurrency build() {
            BankCurrency bankCurrency = new BankCurrency(this);
            return bankCurrency;
        }

    }

}
