package entities.bank;

import javax.persistence.*;
import java.util.List;

@Entity
public class CreditCard {
    @Id
    private Long cardNumber;
    @ManyToMany(mappedBy = "cards", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Client> client;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "Card_cardNumber")
    private List<Account> accounts;

}
