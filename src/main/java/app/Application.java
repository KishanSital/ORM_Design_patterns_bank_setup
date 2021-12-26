package app;

import config.JPAConfiguration;
import dao.BankDAO;
import entities.bank.BankClient;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        JPAConfiguration jpaConfigurationCBVS = new JPAConfiguration("CBVS");
        BankDAO bankDAOCBVS = new BankDAO(jpaConfigurationCBVS.getEntityManager());
        List<BankClient> bankClientListCBVS = bankDAOCBVS.retrieveClientList();
        bankClientListCBVS.forEach(System.out::println);

        JPAConfiguration jpaConfigurationDSB = new JPAConfiguration("DSB");
        BankDAO bankDAODSB = new BankDAO(jpaConfigurationDSB.getEntityManager());
        List<BankClient> bankClientListDSB = bankDAODSB.retrieveClientList();
        bankClientListDSB.forEach(System.out::println);

        JPAConfiguration jpaConfigurationHKB = new JPAConfiguration("HKB");
        BankDAO bankDAOHKB = new BankDAO(jpaConfigurationHKB.getEntityManager());
        List<BankClient> bankClientListHKB = bankDAOHKB.retrieveClientList();
        bankClientListHKB.forEach(System.out::println);
    }

}
