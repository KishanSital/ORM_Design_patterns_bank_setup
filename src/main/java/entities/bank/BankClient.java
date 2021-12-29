package entities.bank;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "bank_client")
@Entity
public class BankClient {
    @Id
    @Column(name = "id_card",unique = true)
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

    public BankClient() {
    }

    public BankClient(Long idCard, String voornaam, String achternaam, LocalDate geboorteDatum, List<BankCard> bankCards) {
        this.idCard = idCard;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboorteDatum = geboorteDatum;
        this.bankCards = bankCards;
    }

    public BankClient(BankClientBuilder bankClientBuilder) {
        this.idCard = bankClientBuilder.idCard;
        this.voornaam = bankClientBuilder.voornaam;
        this.achternaam = bankClientBuilder.achternaam;
        this.geboorteDatum = bankClientBuilder.geboorteDatum;
        this.bankCards = bankClientBuilder.bankCards;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public LocalDate getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(LocalDate geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
    }

    public static class BankClientBuilder {
        private Long idCard;

        private String voornaam;

        private String achternaam;

        private LocalDate geboorteDatum;

        private List<BankCard> bankCards;


        public BankClientBuilder idCard(Long idCard) {
            this.idCard = idCard;
            return this;
        }

        public BankClientBuilder voornaam(String voornaam) {
            this.voornaam = voornaam;
            return this;
        }

        public BankClientBuilder achternaam(String achternaam) {
            this.achternaam = achternaam;
            return this;
        }

        public BankClientBuilder geboorteDatum(LocalDate geboorteDatum) {
            this.geboorteDatum = geboorteDatum;
            return this;
        }

        public BankClientBuilder bankCards(List<BankCard> bankCards) {
            this.bankCards = bankCards;
            return this;
        }

        public BankClient build() {
            BankClient bankClient = new BankClient(this);
            return bankClient;
        }

    }
}
