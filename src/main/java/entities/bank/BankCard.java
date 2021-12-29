package entities.bank;

import javax.persistence.*;
import java.util.List;

@Table(name = "bank_card")
@Entity
public class BankCard {
    @Id
    @Column(name = "card_number",unique = true)
    private Long cardNumber;
    @ManyToMany(mappedBy = "bankCards", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BankClient> bankClient;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "bankCard_card_number")
    private List<BankAccount> bankAccounts;
    @Column(name = "bank_pin")
    private Long bankPin;

    public BankCard(Long cardNumber,
                    List<BankClient> bankClient,
                    List<BankAccount> bankAccounts,
                    Long bankPin) {
        this.cardNumber = cardNumber;
        this.bankClient = bankClient;
        this.bankAccounts = bankAccounts;
        this.bankPin = bankPin;
    }

    public BankCard(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BankCard(BankCardBuilder bankCardBuilder) {
        this.cardNumber = bankCardBuilder.cardNumber;
        this.bankClient = bankCardBuilder.bankClient;
        this.bankAccounts = bankCardBuilder.bankAccounts;
        this.bankPin = bankCardBuilder.bankPin;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<BankClient> getBankClient() {
        return bankClient;
    }

    public void setBankClient(List<BankClient> bankClient) {
        this.bankClient = bankClient;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public Long getBankPin() {
        return bankPin;
    }

    public void setBankPin(Long bankPin) {
        this.bankPin = bankPin;
    }

    public static class BankCardBuilder {
        private Long cardNumber;

        private List<BankClient> bankClient;

        private List<BankAccount> bankAccounts;

        private Long bankPin;

        public BankCardBuilder cardNumber(Long cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public BankCardBuilder bankClient(List<BankClient> bankClient) {
            this.bankClient = bankClient;
            return this;
        }

        public BankCardBuilder bankAccounts(List<BankAccount> bankAccounts) {
            this.bankAccounts = bankAccounts;
            return this;
        }

        public BankCardBuilder bankPin(Long bankPin) {
            this.bankPin = bankPin;
            return this;
        }

        public BankCard build() {
            BankCard bankCard = new BankCard(this);
            return bankCard;
        }

    }
}
