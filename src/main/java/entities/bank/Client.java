package entities.bank;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Client {
    @Id
    private Long idCard;
    @Column
    private String voornaam;
    @Column
    private String achternaam;
    @Column
    private LocalDate geboorteDatum;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "client_card",
            joinColumns = {@JoinColumn(name = "client_idCard")},
            inverseJoinColumns = {@JoinColumn(name = "card_cardNumber")}
    )
    private List<CreditCard> creditCards;
}
