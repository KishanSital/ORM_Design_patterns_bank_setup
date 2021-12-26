package entities.bank;

import javax.persistence.*;

@Table(name = "bank_account_type")
@Entity
public class BankAccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "bank_account_type_description")
    private String bankAccountTypeDescription;
}
