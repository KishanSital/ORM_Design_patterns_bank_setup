package entities.bank;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "bank_account")
@Entity
public class BankAccount {
    @Id
    @Column(name = "account_number",unique = true)
    private Long accountNumber;
    @OneToOne
    private BankAccountType bankAccountType;
    @OneToOne
    private BankCurrency bankCurrency;
    @Column(name = "bank_balance")
    private BigDecimal bankBalance;
    @ManyToOne(fetch = FetchType.EAGER)
    private BankCard bankCard;

    public BankAccount(Long accountNumber, BankAccountType bankAccountType, BankCurrency bankCurrency, BigDecimal bankBalance, BankCard bankCard) {
        this.accountNumber = accountNumber;
        this.bankAccountType = bankAccountType;
        this.bankCurrency = bankCurrency;
        this.bankBalance = bankBalance;
        this.bankCard = bankCard;
    }

    public BankAccount() {
    }

    public BankAccount(BankAccountBuilder bankAccountBuilder) {
        this.accountNumber = bankAccountBuilder.accountNumber;
        this.bankAccountType = bankAccountBuilder.bankAccountType;
        this.bankCurrency = bankAccountBuilder.bankCurrency;
        this.bankBalance = bankAccountBuilder.bankBalance;
        this.bankCard = bankAccountBuilder.bankCard;
    }



    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public BankCurrency getBankCurrency() {
        return bankCurrency;
    }

    public void setBankCurrency(BankCurrency bankCurrency) {
        this.bankCurrency = bankCurrency;
    }

    public BigDecimal getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(BigDecimal bankBalance) {
        this.bankBalance = bankBalance;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public static class BankAccountBuilder {
        private Long accountNumber;

        private BankAccountType bankAccountType;

        private BankCurrency bankCurrency;

        private BigDecimal bankBalance;

        private BankCard bankCard;

        public BankAccountBuilder accountNumber(Long accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public BankAccountBuilder bankAccountType(BankAccountType bankAccountType) {
            this.bankAccountType = bankAccountType;
            return this;
        }

        public BankAccountBuilder bankCurrency(BankCurrency bankCurrency) {
            this.bankCurrency = bankCurrency;
            return this;
        }

        public BankAccountBuilder bankBalance(BigDecimal bankBalance) {
            this.bankBalance = bankBalance;
            return this;
        }

        public BankAccountBuilder bankCard(BankCard bankCard) {
            this.bankCard = bankCard;
            return this;
        }

        public BankAccount build() {
            BankAccount bankAccount = new BankAccount(this);
            return bankAccount;
        }


    }

}
