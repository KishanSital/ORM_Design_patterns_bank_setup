package entities.bank;

import javax.persistence.*;

@Table(name = "bank_account_type")
@Entity
public class BankAccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;
    @Column(name = "bank_account_type_description",unique = true,nullable = false)
    private String bankAccountTypeDescription;

    public BankAccountType(Long id, String bankAccountTypeDescription) {
        this.id = id;
        this.bankAccountTypeDescription = bankAccountTypeDescription;
    }

    public BankAccountType() {
    }

    public BankAccountType(BankAccountTypeBuilder bankAccountTypeBuilder) {
        this.id = bankAccountTypeBuilder.id;
        this.bankAccountTypeDescription = bankAccountTypeBuilder.bankAccountTypeDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankAccountTypeDescription() {
        return bankAccountTypeDescription;
    }

    public void setBankAccountTypeDescription(String bankAccountTypeDescription) {
        this.bankAccountTypeDescription = bankAccountTypeDescription;
    }

    public static class BankAccountTypeBuilder {
        private Long id;

        private String bankAccountTypeDescription;

        public BankAccountTypeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BankAccountTypeBuilder bankAccountTypeDescription(String bankAccountTypeDescription) {
            this.bankAccountTypeDescription = bankAccountTypeDescription;
            return this;
        }

        public BankAccountType build() {
            BankAccountType bankAccountType = new BankAccountType(this);
            return bankAccountType;
        }
    }
}
