package entities.bank;

import javax.persistence.*;
import java.util.List;

@Table(name = "bank_card")
@Entity
public class BankCard {
    @Id
    @Column(name = "card_number")
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

}
