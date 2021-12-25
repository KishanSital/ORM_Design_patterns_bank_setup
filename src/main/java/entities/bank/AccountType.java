package entities.bank;

import javax.persistence.*;

@Entity
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String accountTypeOmschrijving;
}
