package entities.bank;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "bank_client")
@Entity
public class BankClient {
    @Id
    @Column(name = "id_card")
    private Long idCard;
    @Column(name = "voornaam")
    private String voornaam;
    @Column(name = "achternaam")
    private String achternaam;
    @Column(name = "geboorte_datum")
    private LocalDate geboorteDatum;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "bank_client_card",
            joinColumns = {@JoinColumn(name = "bank_client_id_card")},
            inverseJoinColumns = {@JoinColumn(name = "bank_card_card_number")}
    )
    private List<BankCard> bankCards;
}
